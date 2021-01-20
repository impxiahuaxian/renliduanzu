package qdu.java.recruit.controller.hr;

import io.swagger.annotations.Api;
import net.sf.json.JSONObject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import com.github.pagehelper.PageInfo;

import qdu.java.recruit.constant.GlobalConst;
import qdu.java.recruit.controller.BaseController;
import qdu.java.recruit.entity.*;
import qdu.java.recruit.pojo.ApplicationPositionHRBO;
import qdu.java.recruit.pojo.HrCommentBO;
import qdu.java.recruit.pojo.PositionCompanyBO;
import qdu.java.recruit.pojo.UserCommentBO;
import qdu.java.recruit.pojo.UserWorkBO;
import qdu.java.recruit.service.*;
import sun.misc.BASE64Encoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

/**
  <p>
 private int hrId;
 private String hrMobile;
 private String hrPassword;
 private String hrName;
 private String hrEmail;
 private String description;
 private int departmentId;
 </p>
 */
@RestController
@Api(value = "HR接口",description = "HR接口")
public class HRController extends BaseController{

    protected Logger logger = LogManager.getLogger(getClass());

    @Autowired
    HRService hrService;
    
    @Autowired
    CategoryService categoryService;
    
    @Autowired
    ApplicationService applicationService;
    
    @Autowired
    UsercomService usercomService;
    
    @Autowired
    PositionService positionService;
    @Autowired
    ResumeService resumeService;

    @Autowired
    CompanyService companyService;
    @Autowired
    UserService userService;
    @Autowired
    DepartmentService departmentService;

    /**
     * 用户注册返回 0 -> 失败 1 -> 成功
     */

    @PostMapping("/hr/register/first")
    @ResponseBody
    public String checkCompanyCode(ModelMap map,
                                   @RequestParam String CompanyCode,
                                   HttpServletRequest request,
                                   DepartmentEntity departmentEntity) {
        CompanyEntity companyEntity = companyService.getCompany(CompanyCode);
        if(companyEntity == null) {
            throw  new RuntimeException("公司不存在");
        }
        else {
            List<DepartmentEntity> departmentEntities = departmentService.getDepartmentByCompany(
                    companyEntity.getCompanyId());
            map.put("departments",departmentEntities);
            request.setAttribute("department",departmentEntity.getDepartmentId());
            return hrDirect("hr/register/second");
        }
    }



    @PostMapping(value = "hr/register/second")
    @ResponseBody
    public int userRegister( HREntity user,
                            HttpServletRequest request){

            
            String password = user.getHrPassword();

            //验证mobile 和 password是否为空
            if (user.getHrMobile() == null || user.getHrPassword() == null) {
                return 0;
            }
            if (hrService.registerHR(user)) {
                return 1;
            }
            return 1;
        }



    /**
     * 用户登录
     *
     * @param httpSession
     * @param mobile
     * @param password
     * @return
     */
    @PostMapping(value = "hr/login")
    public int userLogin(HttpSession httpSession,
                         @RequestParam String userName,
                         @RequestParam String userPass) {

         if (userName == null || userPass == null) {
            return 0;
        }

        if (hrService.loginHR(userName, userPass)) {

            httpSession.setAttribute("hr", hrService.getHRByMobile(userName));
            return 1;
        }
        return 0;
    }



    /**
     * 用户个人信息 输出
     *
     * @param request
     * @return
     */
    @PostMapping(value = "/hr/info")
    @ResponseBody
    public String showInfo(HttpServletRequest request) {

        //用户个人信息
      
        HREntity hr = this.getHR(request);
//        int id = hr.getHrId();
//        HREntity user = hrService.getHR(5);
        if (hr == null) {
            this.errorDirect_404();
            //其实应该返回的是401，或者403
        }
        int id = hr.getHrId();

        //收件箱
//        List<UserEntity> applyPosList = applicationService.listApplyInfoByHr1(id);
        List<UserWorkBO> applyPosList = applicationService.listApplyInfoByHrtitle(id);
        //创建的职位
        List<PositionEntity> positionEntities = positionService.listPositionByHr(id);

        //正在进行
        List<UserWorkBO> workinglist = applicationService.listApplyInfoByHr2(id);
       //职位
        List<CategoryEntity> allCategoryList = categoryService.getAll(); 
        Map output = new TreeMap();
        output.put("hr", hr);
        output.put("applyPosList", applyPosList);
        output.put("workinglist", workinglist);
        output.put("allCategoryList",allCategoryList);
        output.put("positions",positionEntities);

        JSONObject jsonObject = JSONObject.fromObject(output);

        return jsonObject.toString();
    }
    public String EncodingByMd5(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException {

        //确定计算方法
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        BASE64Encoder base64en = new BASE64Encoder();

        //加密后的字符串
        String encStr = base64en.encode(md5.digest(str.getBytes("utf-8")));
        return encStr;
    }
    /**
     *
     <p>
     private int hrId;
     private String hrMobile;
     private String hrPassword;
     private String hrName;
     private String hrEmail;
     private String description;
     private int departmentId;
     </p>+
     
     * 个人信息更新 功能
     *
     * @param request
     * @param password
     * @param name
     * @param mobile
     * @param email
     * @param description
     * @param departmentId
     * @return
     */
    @PostMapping("/hr/info/update")
    public int updateInfo(HttpServletRequest request,
                             @RequestParam("password") String password,
                             @RequestParam("name") String name,
                             @RequestParam("email") String email,
                             @RequestParam("gender") String hrSex,
                             @RequestParam("graduation") String hrAdress) {

        int hrId = this.getHRId(request);

        HREntity HREntity = new HREntity();
        HREntity.setHrId(hrId);
        String encPass = null;
		try {
			encPass = this.EncodingByMd5(password);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
        HREntity.setHrPassword(encPass);
        HREntity.setHrName(name);
        HREntity.setHrEmail(email);
        HREntity.setHrSex(hrSex);
        HREntity.setHrAddress(hrAdress);

        if (!hrService.updateHR(HREntity)) {
            this.errorDirect_404();
        }
        return 1;
    }

    


    /**
     * 主页分页输出 （用户信息，职位列表）
     *
     * @param page
     * @param limit
     * @return
     */
    @PostMapping(value = "/page1/{page}")
    @ResponseBody
    public String index(HttpSession httpSession, @PathVariable int page, @RequestParam(value = "limit", defaultValue = "6") int limit) {
        //测试用户
//        UserEntity user = userService.getUserByMobile("15788875236");
        HREntity hr = (HREntity) httpSession.getAttribute("hr");

//        UserEntity user = new UserEntity();
//        user = userService.getUser(5);

        //推荐职位列表
        page = (page < 1 || page > GlobalConst.MAX_PAGE) ? 1 : page;

        Map output = new TreeMap();
        try {
            List<UserEntity> posInfo = positionService.userPosition(hr, page, limit);
            output.put("posInfo", posInfo);
        } catch (Exception ex) {
            return "out";
        }
        if (hr != null) {
            output.put("hr", hr);
        }

        JSONObject jsonObject = JSONObject.fromObject(output);
        return jsonObject.toString();
    }
    @PostMapping(value = "/position1/{id}/{page}")
    @ResponseBody
    public String getPosition(HttpSession httpSession, @PathVariable int id, @PathVariable int page,
                              @RequestParam(value = "limit", defaultValue = "12") int limit) {

        PositionEntity position = positionService.getPositionById(id);
        if (position == null) {
            this.errorDirect_404();
        }

        //当前用户信息
        HREntity hr = (HREntity) httpSession.getAttribute("hr");

        //用户
        UserEntity user = userService.getUser(id);
        //分页评论信息
        PageInfo<HrCommentBO> comList =  usercomService.listhrcomment(id,page,limit);
        //用户简历
        ResumeEntity resume = resumeService.getResumeById(id);
        //用户职位
        CategoryEntity category = categoryService.getCategory(user.getDirDesire());
        //创建的所有职位
        List<PositionEntity> positionEntities = positionService.listPositionByHr(hr.getHrId());
        if (!userService.updateHits(id)) {
            this.errorDirect_404();
        }
        Map output = new TreeMap();
        output.put("user", user);
        output.put("hr", hr);
        output.put("comList", comList);
        output.put("category", category);
        output.put("resume", resume);
        output.put("positionEntities",positionEntities);
        JSONObject jsonObject = JSONObject.fromObject(output);
        return jsonObject.toString();
    }
   
}

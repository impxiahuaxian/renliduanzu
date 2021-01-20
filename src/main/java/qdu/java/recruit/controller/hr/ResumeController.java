package qdu.java.recruit.controller.hr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;

import net.sf.json.JSONObject;
import qdu.java.recruit.constant.GlobalConst;
import qdu.java.recruit.controller.BaseController;
import qdu.java.recruit.entity.HREntity;
import qdu.java.recruit.entity.PositionEntity;
import qdu.java.recruit.entity.UserEntity;
import qdu.java.recruit.pojo.PositionCompanyBO;
import qdu.java.recruit.pojo.UserdesireBO;
import qdu.java.recruit.renwu.service.PaperDaoService;
import qdu.java.recruit.service.ApplicationService;
import qdu.java.recruit.service.HrappService;
import qdu.java.recruit.service.PositionService;
import qdu.java.recruit.service.UserService;
import qdu.java.recruit.service.UsercomService;
import qdu.java.recruit.service.impl.HrappServiceImpl;

import java.util.Map;
import java.util.TreeMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
public class ResumeController extends BaseController{
	@Resource
    private PositionService positionService;
	@Resource
    private ApplicationService applicationService;
	@Resource
	private UsercomService usercomService;
	@Autowired
	private PaperDaoService service;
	@Autowired
	private UserService userService;
	@Autowired
	private HrappService hrappService;
	
    @PostMapping("/hr/applyInfo")
    public String ResumeInfo(HttpServletRequest request) {
        HREntity hr = this.getHR(request);
        if(hr == null) {
            return errorDirect_404();
        }
        return null;
    }
    /*
     * 拒绝
     */
    @PostMapping(value = "/hr/refuse/{id}/{workid}")
    public boolean refusePosition(HttpServletRequest request, @PathVariable int id, @PathVariable int workid) {

        //当前用户
    	int hrId = this.getHRId(request);
    	int state = 2;
    	boolean a;
    	
    	int nwl = applicationService.stateApplication(id,workid);
    	if(nwl==1) {
    		a = false;
    	}else {
    	 a = applicationService.refusePosition(state, hrId, id,workid);
    	}
        return a;
    }
    @PostMapping(value = "/hr/agree/{id}/{workid}")
    public boolean agreePosition(HttpServletRequest request, @PathVariable int id, @PathVariable int workid) {

        //当前用户
    	int hrId = this.getHRId(request);
    	int state = 1;
    	boolean a = applicationService.refusePosition(state, hrId, id,workid);
        return a;
    }
    @PostMapping(value = "/hr/plan/{id}/{workid}")
    public int planPosition(HttpServletRequest request, @PathVariable int id, @PathVariable int workid) {
    	int c = 0;
        //当前用户
    	c = service.idPaper(workid,id);
    	
        return c;
    }
    @PostMapping(value = "/hr/pingfen")
    public int pingfen(HttpServletRequest request,  int userid, int fenshu, int positionId,String pinglun) {
    	int c = 0;
        //当前用户
    	
    	HREntity hr = this.getHR(request);
    	int hrId = hr.getHrId();
    	c = usercomService.saveUsercom(fenshu, userid, hrId, positionId,pinglun);
    	
        return c;
    }
    @PostMapping(value = "/hr/jieshu/{id}/{workid}")
    public boolean jieshu(HttpServletRequest request, @PathVariable int id, @PathVariable int workid) {

        //当前用户
    	int hrId = this.getHRId(request);
    	int state = 3;
    	boolean a = applicationService.refusePosition(state, hrId, id,workid);
        return a;
    }
    
    
    @PostMapping(value = "/hr/Determine")
    public boolean Determine(HttpServletRequest request, int userid,  int workid) {

        //当前用户
    	int hrId = this.getHRId(request);
    	boolean nwl =false;
    	nwl =hrappService.inserthrapp(workid, hrId, userid);
        return nwl;
    }
    /**
     * 职位搜索页分页输出 （关键字，职位列表）
     *
     * @param request
     * @param keyword
     * @param page
     * @param limit
     * @return
     */
    @PostMapping(value = "/hr/search")
    @ResponseBody
    public String search(HttpServletRequest request, @RequestParam(value = "keyword",defaultValue="") String keyword,
                         @RequestParam(value="orderBy",defaultValue = "salaryUp") String orderBy,@RequestParam(value="page",defaultValue = "1") int page,
                         @RequestParam(value = "limit", defaultValue = "6") int limit) {
        HREntity hr = this.getHR(request);

        page = page < 1 || page > GlobalConst.MAX_PAGE ? 1 : page;
        PageInfo<UserdesireBO> posInfo = userService.searchUser(keyword,orderBy, page, limit);

        Map output = new TreeMap();
        output.put("hr",hr);
        output.put("title", ("第" + page + "页"));
        output.put("keyword", keyword);
        output.put("orderBy", orderBy);
        output.put("posInfo", posInfo);

        JSONObject jsonObject = JSONObject.fromObject(output);

        return jsonObject.toString();
    }
}

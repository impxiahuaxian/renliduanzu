package qdu.java.recruit.controller.user;

import io.swagger.annotations.Api;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import qdu.java.recruit.controller.BaseController;


@Controller
@EnableAutoConfiguration
@Api("页面跳转控制器")
public class IndexController extends BaseController {
    private static final Logger LOGGER = LogManager.getLogger();

    /**
     * 用户登录
     *
     * @return
     */
    @GetMapping(value = "user/login")
    public String userLogin() {
        return this.userDirect("user_login");
    }
    /**
     * 用户登录
     *
     * @return
     */
    @GetMapping(value = "hr/renwu")
    public String userLogin1() {
        return this.renwuDirect("index");
    }
  
    @GetMapping(value = "/createnew")
    public String renwuLogin21() {
        return this.renwuDirect("createnew");
    }
   
    @GetMapping(value = "/renwu/agreesuccess")
    public String renwuLogin2() {
        return this.renwuDirect("agree_success");
    }
    @GetMapping(value = "/tittle")
    public String renwuLogin3() {
        return this.renwuDirect("tittle");
    }
    @GetMapping(value = "/mylist")
    public String renwuLogin4() {
        return this.renwuDirect("mylist");
    }
   
    @GetMapping(value = "/addproblem")
    public String renwuLogin5() {
        return this.renwuDirect("addproblem");
    }
  
    @GetMapping(value = "/showpaper")
    public String renwuLogin6() {
        return this.renwuDirect("showpaper");
    }
    
    @GetMapping(value = "/updatequestion")
    public String renwuLogin7() {
        return this.renwuDirect("updatequestion");
    }
    @GetMapping(value = "/usepaper")
    public String renwuLogin8() {
        return this.renwuDirect("usepaper");
    }
    @GetMapping(value = "/result")
    public String renwuLogin9() {
        return this.renwuDirect("result");
    }
    /**
     * 主页
     *
     * @return
     */
    @GetMapping(value = "")
    public String index() {
        return this.userDirect("index");
    }

    /**
     * 职位搜索 列表页
     *
     * @return
     */
    @GetMapping(value = "/searchlist")
    public String search() { return this.userDirect("search_list"); }

    /**
     * 职位分类 列表页
     *
     * @return
     */
    @GetMapping(value = "/category/{id}")
    public String list() {
        return this.userDirect("category_list");
    }

    /**
     * 职位细节页
     *
     * @return
     */
    @GetMapping(value = "/position/{id}")
    public String getPosition() {
        return this.userDirect("position_detail");
    }

    /**
     * 用户中心页
     *
     * @return
     */
    @GetMapping(value = "user/info")
    public String userInfo() {
        return this.userDirect("user_info");
    }
    /**
     * 用户中心页
     *
     * @return
     */
    @GetMapping(value = "hr/info")
    public String userInfo1() {
        return this.hrDirect("user_info");
    }
   
    @GetMapping(value = "hr/pingjia")
    public String pingjia() {
        return this.hrDirect("pingjia");
    }
  
    @GetMapping(value = "hr/searchlist")
    public String searchlist() {
        return this.hrDirect("search_list");
    }
    /**
     * 用户简历页
     * @return
     */
    @GetMapping(value = "user/resume")
    public String userResume() {
        return this.userDirect("user_resume");
    }

    /**
     * 职位申请成功页
     * @return
     */
    @GetMapping(value = "user/success")
    public String applySuccess() {
        return this.userDirect("apply_success");
    }
    /**
     * 职位申请成功页
     * @return
     */
    @GetMapping(value = "hr/success")
    public String applySuccess1() {
        return this.hrDirect("Release_success");
    }
    /**
     * 用户细节页
     *
     * @return
     */
    @GetMapping(value = "/position1/{id}")
    public String getPosition1() {
        return this.hrDirect("user_detail");
    }

  
}

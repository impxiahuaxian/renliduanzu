package qdu.java.recruit.controller.general;

import io.swagger.annotations.Api;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@EnableAutoConfiguration
public class GeneralController {

    /**
     * 注册
     *
     * @return
     */
    @GetMapping(value = "/register")
    public String hrRegister() {
        return "general/register";
    }
    @GetMapping(value = "/hr/register")
    public String userRegister() {
        return "general/hr_register";
    }
    @GetMapping(value = "/hr/hr_login")
    public String hrlogin() {
        return "hr/hr_login";
    }
    @GetMapping(value = "/hr/index")
    public String hrindex() {
        return "/hr/index";
    }
    
}

package com.terrace.controller;

import com.terrace.entity.User;
import com.terrace.form.UserLoginForm;
import com.terrace.service.IUserService;
import com.terrace.utils.MD5Utils;
import com.terrace.vo.ResultData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @project: JPA
 * @author: zhs
 * @date: 2018/10/14 11:01
 * @package: com.qq.controller
 * @description: 用户登录注册的api
 */
@Controller
@Slf4j
public class LoginController {

    @Autowired
    private IUserService userService;


    /**
     * @Decription: 请求登录页面的
     * @param: []
     * @return: java.lang.String
     * @auther: zhs
     * @date: 2018/10/15 9:05
     * @remarks:
     */
    @GetMapping(value = {"/login"})
    public  String  login(){
         return  "login";
    }


    /**
     * @Decription: 登录的请求路径
     * @param: [userName, password]
     * @return: java.lang.String
     * @auther: zhs
     * @date: 2018/10/15 9:06
     * @remarks:
     */
    @PostMapping("/login")
    @ResponseBody
    public ResultData login(@Validated UserLoginForm userForm, HttpServletRequest request){
        final String username = userForm.getUsername();
        final String password = userForm.getPassword();
        final User user = userService.findUserByUserName(username);
        String password1 =  MD5Utils.md5(password);
        if(!password1.equals(user.getPassword())){
          return ResultData.error("用户名和密码错误");
        }
        request.getSession().setAttribute("user",user);
        return ResultData.success("登陆成功");

    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request) {
        request.getSession().removeAttribute("user");
        return "/login";
    }


    @GetMapping({"/","/index"})
    public String index(){
        return "pc/index";
    }

    @GetMapping({"/contact"})
    public String contact(){
        return "pc/contact";
    }
}

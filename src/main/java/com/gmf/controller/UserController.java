package com.gmf.controller;

import com.gmf.entity.User;
import com.gmf.service.UserService;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class UserController {

    @Resource
    private UserService userService;
    @RequestMapping("/reg")
    public ModelAndView reg(User user){
        System.out.println("--reg--");
        System.out.println("oldUser:"+user);
        ModelAndView mav=new ModelAndView();
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<6;i++){
            char c=(char)(int)(Math.random()*26+97);
            sb.append(c);
        }
        String salt=sb.toString();

        SimpleHash sh=new SimpleHash("MD5",user.getPassword(),salt,3);

        String password=sh.toString();

        user.setPassword(password);
        user.setSalt(salt);

        userService.saveUser(user);
        System.out.println("newUser:"+user);
        mav.getModel().put("user",user);
        mav.setViewName("/WEB-INF/jsp/success.jsp");
        return mav;
    }
    @RequestMapping("/login")
    public void login(HttpServletResponse response, HttpServletRequest request) throws Exception{
        System.out.println("--login--");

        //登录失败之后才跳转
        request.getRequestDispatcher("/login.jsp").forward(request,response);
    }
}

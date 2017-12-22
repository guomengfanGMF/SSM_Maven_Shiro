package com.gmf.controller;

import com.gmf.entity.Gn;
import com.gmf.mapper.UserMapper;
import com.gmf.service.UserService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class GnController {
    @Resource
    private UserService userService;

    @RequestMapping("/selAllgn")
    public ModelAndView selAllgn(){
        ModelAndView mav=new ModelAndView();
        List<Gn> gns=userService.selAllgn();
        mav.getModel().put("gns",gns);
        mav.setViewName("/WEB-INF/jsp/main.jsp");
        return mav;
    }

    @RequiresPermissions("user:query")
    @RequestMapping("user_query")
    public ModelAndView userQuery(){
        ModelAndView mav=new ModelAndView();
        mav.getModel().put("info","查询全部用户");
        mav.setViewName("/WEB-INF/jsp/success.jsp");

        return mav;
    }

    @RequiresPermissions("good:query")
    @RequestMapping("good_query")
    public ModelAndView goodQuery(){
        ModelAndView mav=new ModelAndView();
        mav.getModel().put("info","查询全部用户");
        mav.setViewName("/WEB-INF/jsp/success.jsp");

        return mav;
    }

}

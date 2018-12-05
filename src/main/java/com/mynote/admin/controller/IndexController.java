package com.mynote.admin.controller;

import com.mynote.admin.config.WebSecurityConfig;
import com.mynote.admin.model.LoginUserInfo;
import com.mynote.admin.model.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * LoginController
 *
 */
@RestController
public class IndexController {

    @RequestMapping(value= "/page/main" , method = RequestMethod.GET)
    public ModelAndView mainPage(HttpServletRequest request){
        ModelAndView mv = new ModelAndView("main");
        Object userName = request.getSession().getAttribute(WebSecurityConfig.SESSION_KEY);
        mv.addObject("username" , userName);
        return mv;
    }


}//end class

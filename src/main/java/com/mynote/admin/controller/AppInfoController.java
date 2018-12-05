package com.mynote.admin.controller;

import com.mynote.admin.config.WebSecurityConfig;
import com.mynote.admin.model.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * LoginController
 *
 */
@RestController
public class AppInfoController {

    @RequestMapping(value= "/api/versionlist" , method = RequestMethod.GET)
    public List<String> findAppVersionList(HttpServletRequest request) throws Exception{
        if(true)
            throw new Exception("我也不知道是什么的错误");
        return null;
    }

    @RequestMapping(value= "/api/addversion" , method = RequestMethod.GET)
    public Result<String> addAppVersion(HttpServletRequest request){
        return null;
    }

}//end class

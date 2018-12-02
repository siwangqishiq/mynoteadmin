package com.mynote.admin.controller;

import com.mynote.admin.config.WebSecurityConfig;
import com.mynote.admin.model.LoginUserInfo;
import com.mynote.admin.model.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * LoginController
 *
 */
@RestController
public class LoginController {

    @RequestMapping(value= "/api/dologin" , method = RequestMethod.POST)
    public Result<LoginUserInfo> doLogin(LoginUserInfo loginInfo,HttpSession session){
        Result<LoginUserInfo> result = new Result<LoginUserInfo>();
        if(WebSecurityConfig.isValidate(loginInfo.getUsername() , loginInfo.getPwd())){
            loginInfo.setPwd(null);
            result.setSuccessData(loginInfo);
            session.setAttribute(WebSecurityConfig.SESSION_KEY , loginInfo.getUsername());
        }else{
            result.setError("password error");
        }
        return result;
    }

}//end class

package com.mynote.admin.config;

import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

public class WebSecurityConfig {
    public static final String SESSION_KEY = "session_key";

    public static Map<String , String> users = new HashMap<String,String>();
    static {
        users.put("mingyan" , "900523");
        users.put("panyi" , "891013");
    }


    public static boolean isValidate(final String username , final String pwd){
        if(users.get(username) == null) {
            return false;
        }

        if(users.get(username).equalsIgnoreCase(pwd)){
            return true;
        }else{
            return false;
        }
    }
}//end class

package com.mynote.admin.controller;

import com.mynote.admin.config.WebSecurityConfig;
import com.mynote.admin.model.Result;
import com.mynote.admin.model.Version;
import com.mynote.admin.service.VersionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/**
 * LoginController
 *
 */
@RestController
public class AppInfoController {
    @Autowired
    private VersionService versionService;

    @RequestMapping(value= "/api/addversion" , method = RequestMethod.GET)
    public List<String> findAppVersionList(HttpServletRequest request) throws Exception{
        Version version = new Version();
        version.setDescrption("测试看看");
        version.setVersionCode(1);
        version.setVersionName("1.0");
        version.setUrl("http://www.sex520.com");
        version.setStatus(Version.STATUS_IDLE);
        version.setType(Version.TYPE_ANDROID);
        version.setUpdateTime(new Date().getTime());
        version.setCreateTime(new Date().getTime());
        long id = versionService.addNewVersion(version);
        System.out.println("id = " + id);
        return null;
    }

    @RequestMapping(value= "/api/versionList" , method = RequestMethod.GET)
    public Result<String> addAppVersion(HttpServletRequest request){
        return null;
    }

}//end class

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

    @RequestMapping(value= "/api/addversion" , method = RequestMethod.POST)
    public Result<Long> addAppVersion(HttpServletRequest request,Version version) throws Exception{
        System.out.println("version = " +version.toString());
        long id = versionService.addNewVersion(version);
        System.out.println("id = " + id);
        Result<Long> result = new Result<Long>();
        result.setSuccessData(id);
        return result;
    }

    @RequestMapping(value= "/api/versionList" , method = RequestMethod.GET)
    public Result<List<Version>> addAppVersion(HttpServletRequest request,int platform){
        Result<List<Version>> result = new Result<List<Version>>();
        if(platform == Version.TYPE_ANDROID){
            result.setSuccessData(versionService.findAndroidVersionList());
        }else if(platform == Version.TYPE_IOS){
            result.setSuccessData(versionService.findIOSVersionList());
        }else{
            result.setError("platform error");
        }
        return result;
    }

    @RequestMapping(value= "/api/versionList" , method = RequestMethod.DELETE)
    public Result<Boolean> deleteAppVersion(int id) throws Exception{
        if(id <= 0)
            throw new Exception("删除id不合法");
        Result<Boolean> result = new Result<Boolean>();
        result.setSuccessData(versionService.deleteVersionById(id));
        return result;
    }

}//end class

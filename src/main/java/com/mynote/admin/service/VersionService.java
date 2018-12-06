package com.mynote.admin.service;

import com.mynote.admin.dao.AppVersionDao;
import com.mynote.admin.model.Version;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VersionService {
    @Autowired
    private AppVersionDao appVersionDao;

    public int addNewVersion(Version version){
        appVersionDao.insert(version);
        return version.getId();
    }

    public List<Version> findAndroidVersionList(){
        return appVersionDao.findVersionListByType(Version.TYPE_ANDROID);
    }

    public List<Version> findIOSVersionList(){
        return appVersionDao.findVersionListByType(Version.TYPE_IOS);
    }

    public Version findVersionById(int id){
        return appVersionDao.findVersionById(id);
    }
}//end class

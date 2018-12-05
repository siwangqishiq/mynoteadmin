package com.mynote.admin.service;

import com.mynote.admin.dao.AppVersionDao;
import com.mynote.admin.model.Version;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VersionService {
    @Autowired
    private AppVersionDao appVersionDao;

    public long addNewVersion(Version version){
        return appVersionDao.insert(version);
    }

}//end class

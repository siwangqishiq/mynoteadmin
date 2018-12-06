package com.mynote.admin.service;

import com.mynote.admin.dao.AppVersionDao;
import com.mynote.admin.model.Version;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VersionService {
    @Autowired
    private AppVersionDao appVersionDao;

    public int addNewVersion(Version version){
        appVersionDao.insert(version);
        return version.getId();
    }


}//end class

package com.mynote.admin;

import com.mynote.admin.model.Version;
import com.mynote.admin.service.VersionService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class VersionServiceTest {
    @Autowired
    private VersionService versionService;

    @Test
    public void testServiceAdd(){
        Version version = new Version();
        version.setType(Version.TYPE_IOS);
        version.setVersionCode(2);
        version.setVersionName("1.2");
        version.setUrl("http://11111.app");
        version.setDescrption("我是IOS介绍");
        version.setStatus(Version.STATUS_IDLE);
        version.setUpdateTime(System.currentTimeMillis());
        version.setCreateTime(System.currentTimeMillis());

        int id = versionService.addNewVersion(version);
        Assert.assertEquals(id > 0 , true);
    }

    @Test
    public void testServicefind(){
        Version version = new Version();
        version.setType(Version.TYPE_ANDROID);
        version.setVersionCode(2);
        version.setVersionName("1.2");
        version.setUrl("http://xxx.apk");
        version.setDescrption("我是android介绍");
        version.setStatus(Version.STATUS_IDLE);
        version.setUpdateTime(System.currentTimeMillis());
        version.setCreateTime(System.currentTimeMillis());

        int id = versionService.addNewVersion(version);

        Version v = versionService.findVersionById(id);
        Assert.assertEquals(v.getVersionName() , version.getVersionName());
    }

    @Test
    public void testServicefindList(){
        List<Version> list = versionService.findAndroidVersionList();
        Assert.assertEquals(list.size() > 0, true);

        List<Version> list2 = versionService.findIOSVersionList();
        Assert.assertEquals(list2.size() > 0, true);
    }
}

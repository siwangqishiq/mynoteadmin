package com.mynote.admin.dao;

import com.mynote.admin.model.Version;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Mapper
 * @Repository
 */
@Mapper
@Repository
public interface AppVersionDao {

    @Insert("insert into version(versionCode,versionName,url," +
            "descrption,extra,status,type,updateTime,createTime) " +
            "values(#{versionCode},#{versionName}," +
            "#{url},#{descrption},#{extra},#{status},#{type},#{updateTime},#{createTime})")
    @SelectKey(statement = "select max(rowid) from version",
            before = false, keyProperty = "id", resultType = int.class)
    public void insert(Version appVersion);

    @Select("select " +
            "id,versionCode,versionName,url,descrption,extra,status,type,updateTime,createTime" +
            " from version where type = #{type} order by updateTime desc")
    public List<Version> findVersionListByType(int type);

    @Select("select " +
            "id,versionCode,versionName,url,descrption,extra,status,type,updateTime,createTime" +
            " from version where id = #{id}")
    public Version findVersionById(int id);

    @Delete("delete from version where id = #{id}")
    public long removeVersionById(int id);
}//end class

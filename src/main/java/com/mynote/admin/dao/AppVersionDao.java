package com.mynote.admin.dao;

import com.mynote.admin.model.Version;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectKey;
import org.springframework.stereotype.Repository;

/**
 * @Mapper
 * @Repository
 * public interface ModelDao {
 *
 *     @Select("select * from test_user where id=#{id}")
 *     public User getNameById(@Param("id") long id);
 *
 *
 * id LONG PRIMARY KEY NOT NULL,
 *     versionCode INT NOT NULL,
 *     versionName VARCHAR(100),
 *     versionType INT NOT NULL,
 *     url VARCHAR(1000),
 *     descrption NVARCHAR(500),
 *     extra NVARCHAR(500),
 *     status INT DEFAULT 0,
 *     type INT NOT NULL

 *
 *     @Select("select * from test_user")
 *     public List<User> findUserList();
 * }
 */

@Mapper
@Repository
public interface AppVersionDao {

    @Insert("insert into version(versionCode,versionName,url," +
            "descrption,extra,status,type,updateTime,createTime) " +
            "values(#{versionCode},#{versionName}," +
            "#{url},#{descrption},#{extra},#{status},#{type},#{updateTime},#{createTime})")
    @SelectKey(statement = "SELECT seq id FROM sqlite_sequence WHERE (name = 'version')",
            before = false, keyProperty = "id", resultType = int.class)
    public int insert(Version appVersion);

    //@SelectKey()
    public Version findVersionById(int id);
}//end class

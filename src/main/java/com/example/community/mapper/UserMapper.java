package com.example.community.mapper;

import com.example.community.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper{
    @Insert("insert into user (name,account_id,token,gmt_create,gmt_modified,avatarUrl) " +
            "values (#{name}, #{accountId}, #{token}, #{gmtCreate}, #{gmtModified},#{avatarUrl})")
     void insert(User user);

    @Select("SELECT * FROM user Where token = #{token}")
    User findByToken(@Param("token") String value);

    @Select("SELECT * FROM user WHERE id = #{id}")
    User findById(@Param("id") int value);
}

package com.example.community.mapper;

import com.example.community.model.Question;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface QuestionMapper {

    @Insert("INSERT INTO Question (title, description,gmt_create,gmt_modified,creator,tag, avatarUrl) " +
            "VALUES (#{title},#{description},#{gmtCreate},#{gmtModified},#{creator},#{tag},#{avatarUrl})")
    void create(Question question);

    @Select("SELECT * FROM Question")
    List<Question> list();
}

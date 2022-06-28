package com.example.community.RestController;


import com.example.community.mapper.QuestionMapper;
import com.example.community.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1")
public class RestIndexController {
    @Autowired
    private QuestionMapper questionMapper;

    //get All Questions
    @GetMapping("/questions")
    public List<Question> getAllQuestions() {
        return questionMapper.list();
    }

}

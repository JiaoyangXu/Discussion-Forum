package com.example.community.controller;

import com.example.community.dto.QuestionDTO;
import com.example.community.mapper.QuestionMapper;
import com.example.community.mapper.UserMapper;
import com.example.community.model.Question;
import com.example.community.model.User;
import com.example.community.service.QuestionService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class indexController {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private QuestionMapper questionMapper;

    @Autowired
    private QuestionService questionService;


    @GetMapping("/")
    public String index(HttpServletRequest request,
                        @RequestParam(value = "currentPage", required = false, defaultValue = "1") String currentPage,
                        Model model) {
        Cookie[] cookies =  request.getCookies();
        if(cookies == null || cookies.length== 0) return "index";
        for(Cookie cookie : cookies) {
            if(cookie.getName().equals("token")) {
                String value = cookie.getValue();
                User user = userMapper.findByToken(value);
                if(user != null) {
                    request.getSession().setAttribute("user",user);
                }
                break;
            }
        }

        // Show Description of Questions on index page
        List<QuestionDTO> questionDTOS = questionService.list();
        PageInfo<QuestionDTO> pageInfo = questionService.listWithPages(Integer.parseInt(currentPage),5);
        model.addAttribute("questionPageInfo", pageInfo);
        model.addAttribute("questionDTOS", questionDTOS);
        model.addAttribute("QuestionPageNumber", questionDTOS.size()/5 +1);
        return "index";
    }
}

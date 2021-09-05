package com.example.community.controller;

import com.example.community.mapper.QuestionMapper;
import com.example.community.mapper.UserMapper;
import com.example.community.model.Question;
import com.example.community.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Controller
public class publishController {

    @Autowired
    UserMapper userMapper;

    @Autowired
    QuestionMapper questionMapper;

    @GetMapping("/publish")
    public String publish() {
        return "publish";
    }

    @PostMapping("/publish")
    public String doPublish(
            @RequestParam(value = "title", required = false, defaultValue = "") String title,
            @RequestParam(value = "description", required = false, defaultValue = "") String description,
            @RequestParam(value = "tag", required = false, defaultValue = "") String tag,
            HttpServletRequest request,
            Model model
            ) {
        Cookie[] cookies = request.getCookies();
        User user = null;
        for(Cookie cookie: cookies) {
            if(cookie.getName().equals("token") ) {
                String token = cookie.getValue();
                user = userMapper.findByToken(token);
                System.out.println(token);
                if(user != null){
                    request.getSession().setAttribute("user", user);
                }
                break;
            }
        }
        if(user == null) {
            model.addAttribute("error", "Please log in");
            return "publish";
        }
        Question question = new Question();
        question.setTitle(title);
        question.setTag(tag);
        question.setDescription(description);
        question.setGmtCreate(System.currentTimeMillis());
        question.setGmtModified(System.currentTimeMillis());
        question.setCreator(user.getId());

        questionMapper.create(question);
        return "redirect:/";
    }
}

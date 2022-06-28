package com.example.community.RestController;


import com.example.community.mapper.UserMapper;
import com.example.community.model.User;
import com.example.community.provider.GithubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class UserController {

    @Autowired
    GithubProvider githubProvider;

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/user")
    public User getCurrentUser() {
        return null;
    }



}

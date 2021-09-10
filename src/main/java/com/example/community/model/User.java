package com.example.community.model;

import lombok.Data;

import java.util.UUID;

@Data
public class User {
    private int id;
    private String name;
    private String accountId;
    private String token;
    private Long gmtCreate;
    private Long gmtModified;
    private String avatarUrl;


    public User(long id, String name, String avatarUrl ) {
        this.accountId = String.valueOf(id);
        this.name = name;
        this.avatarUrl = avatarUrl;
        gmtCreate = System.currentTimeMillis();
        token = UUID.randomUUID().toString();
    }
    public User() {}
}

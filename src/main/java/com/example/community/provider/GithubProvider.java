package com.example.community.provider;

import com.alibaba.fastjson.JSON;
import com.example.community.dto.AccessTokenDTO;
import com.example.community.dto.GithubUser;
import okhttp3.*;
import org.springframework.boot.autoconfigure.info.ProjectInfoProperties;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.sql.Time;
import java.util.concurrent.TimeUnit;


@Component
public class GithubProvider {

    private final static int READ_TIMEOUT =100;
    private final static int  CONNECT_TIMEOUT = 60;
    private final static int WRITE_TIMEOUT = 60;

    public String getAccessToken(AccessTokenDTO accessTokenDTO) {

        MediaType mediaType = MediaType.get("application/json; charset=utf-8");
        OkHttpClient client = new OkHttpClient();
            RequestBody body = RequestBody.create(mediaType, JSON.toJSONString(accessTokenDTO));
            Request request = new Request.Builder()
                    .url("https://github.com/login/oauth/access_token")
                    .post(body)
                    .build();


        OkHttpClient.Builder clientBuilder = new OkHttpClient.Builder();
        // Read timeout
        clientBuilder.readTimeout(READ_TIMEOUT, TimeUnit.SECONDS);
        clientBuilder.connectTimeout(CONNECT_TIMEOUT,TimeUnit.SECONDS);
        clientBuilder.writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS);
        client  = clientBuilder.build();
        try (Response response = client.newCall(request).execute()) {
                // check if the String is our expected token
                String token = response.body().string();
                String [] split = token.split("&");
                String tokenString = split[0];
                String real_token = tokenString.split("=")[1];

                System.out.println(real_token);
                return real_token;
            } catch (Exception e) {
                e.printStackTrace();
        }
            return null;
    }

    public GithubUser getUser(String accessToken) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://api.github.com/user")
                .header("Authorization","token "+accessToken)
                .build();
        try (Response response = client.newCall(request).execute()) {
            String info = response.body().string();
            GithubUser githubUser = JSON.parseObject(info,GithubUser.class);
            return githubUser;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}

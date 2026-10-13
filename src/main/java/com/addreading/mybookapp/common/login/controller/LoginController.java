package com.addreading.mybookapp.common.login.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 로그인 Controller
 * 260902
 */
 @Slf4j
 @Controller
 @RequestMapping("/login")
 public class LoginController {

    @Value("${kakao.client-id}")
    private String clientId;
    @Value("${kakao.redirect-uri}")
    private String redirectUri;

    /**
    * 카카오 로그인 화면을 띄운다.
    *
    * @return 카카오 인증 페이지
    */
    @GetMapping("/kakao")
    public String loginPage() {
        log.info("--------------loginPage 시작--------------");
        String location = "https://kauth.kakao.com/oauth/authorize?response_type=code&client_id="+clientId+"&redirect_uri="+redirectUri;

        return "redirect:" + location;
    }


}
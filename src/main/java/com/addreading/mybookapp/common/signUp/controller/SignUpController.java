package com.addreading.mybookapp.common.signUp.controller;

import com.addreading.mybookapp.common.signUp.dto.SignUpDto;
import com.addreading.mybookapp.common.signUp.service.SignUpService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * 회원가입 Controller
 * 261008
 */
 @Slf4j
 @RestController
 @RequiredArgsConstructor
 @RequestMapping("/signUp")
 public class SignUpController {

    private final SignUpService signUpService;

    @Value("${kakao.client-id}")
    private String clientId;
    @Value("${kakao.redirect-uri}")
    private String redirectUri;

    /**
     * 회원가입하기
     * param HttpRequest request
     * param HttpResponse response
     * param signUpDto signUpDto
     * return void
     * throws Exception
     */
    @PostMapping("/mbrSignUp")
    @ResponseBody
    public void mbrSignUp(HttpServletRequest request, HttpServletRequest response,
                          @RequestBody SignUpDto signUpDto) throws Exception {
        log.info("--------------mbrSignUp 시작--------------");
        signUpService.mbrSignUp(signUpDto);
    }




    /**
    * 카카오 가입 api 띄운다.
    *
    * @return 카카오 인증 페이지
    */
    @GetMapping("/kakaoAuth")
    public String kkoAuthPage() {
        log.info("--------------kkoAuthPage 시작--------------");
        //url 수정필요
        String location = "https://kauth.kakao.com/oauth/authorize?response_type=code&client_id="+clientId+"&redirect_uri="+redirectUri;
        return "redirect:" + location;
    }


}
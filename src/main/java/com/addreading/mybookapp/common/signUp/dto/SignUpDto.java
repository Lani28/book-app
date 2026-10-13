package com.addreading.mybookapp.common.signUp.dto;

import lombok.Data;

/**
 * 회원가입 DTO
 * 261008
 */
@Data
public class SignUpDto {
    private int mebSeq;         //시퀀스
    private String memberId;    //회원계정
    private String memberPw;    //비밀번호
    private String snsId;       //sns계정
    private String snsType;     //sns종류
    private String email;       //이메일
    private String nickname;    //별명
    private String createdAt;   //가입일자

}
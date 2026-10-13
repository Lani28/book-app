package com.addreading.mybookapp.common.signUp.service;

import com.addreading.mybookapp.common.signUp.dto.SignUpDto;

/**
 * 회원가입 service
 * 261008
 */
public interface SignUpService {

    /**
     * 회원가입하기
     * param SignUpDto signUpDto
     * return void
     * throws Exception
     */
    public void mbrSignUp (SignUpDto signUpDto) throws Exception;
}

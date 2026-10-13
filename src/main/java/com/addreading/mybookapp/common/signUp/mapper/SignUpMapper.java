package com.addreading.mybookapp.common.signUp.mapper;

import com.addreading.mybookapp.common.signUp.dto.SignUpDto;
import org.apache.ibatis.annotations.Mapper;

/**
 * 회원가입 Mapper
 * 261008
 */
@Mapper
public interface SignUpMapper {

    /**
     * 회원가입하기
     * param SignUpDto signUpDto
     * return void
     * throws Exception
     */
    void insertMbrSignUp(SignUpDto signUpDto) throws Exception;

}

package com.addreading.mybookapp.common.signUp.service;

import com.addreading.mybookapp.common.signUp.dto.SignUpDto;
import com.addreading.mybookapp.common.signUp.mapper.SignUpMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * 회원가입 serviceImpl
 * 261008
 */

@Service
@RequiredArgsConstructor
public class SignUpServiceImpl implements SignUpService {

    private final SignUpMapper signUpMapper;
    private final PasswordEncoder passwordEncoder;

    /**
     * 회원가입하기
     * param SignUpDto signUpDto
     * return void
     * throws Exception
     */
    @Override
    public void mbrSignUp(SignUpDto signUpDto) throws Exception {
        //비밀번호 암호화
        String encodedPassword = passwordEncoder.encode(signUpDto.getMemberPw());
        signUpDto.setMemberPw(encodedPassword);
        signUpMapper.insertMbrSignUp(signUpDto);
    }
}

<script setup>
import {ref} from "vue";
import axios from "axios";

const email = ref('')
const password = ref('')

//유효성 확인
function fnLoginValidation() {
  console.log('로그인 시도:', email.value, password.value);

  if (email.value === '') {
    alert('이메일을 입력하세요.')
    return
  }else if(email.value.length > 30) {
    alert('글자수를 초과하였습니다.')
    return
  }

  if (password.value === '') {
    alert('비밀번호를 입력하세요.')
    return
  }

  fnLogin()
}

//로그인
function fnLogin(){
  axios.post('/api/login', {
    email: email.value,
    password: password.value
  }
  ).then(function(response) {
    alert('로그인 되었습니다.')
  }
  ).catch(function (error){
    alert('로그인 실패')
    console.log(error)
  })
}

//카카오 로그인
function kakaoLogin(){
    window.location.href = 'http://localhost:8080/login/kakao';
}
</script>

<template>
  <div class="login-wrapper">
    <div class="login-card">
      <h2>로그인</h2>
      <form @submit.prevent="fnLoginValidation">
        <div class="input-group">
          <label for="email">이메일</label>
          <input type="email" id="email" v-model="email" placeholder="이메일을 입력하세요" required />
        </div>
        <div class="input-group">
          <label for="password">비밀번호</label>
          <input type="password" id="password" v-model="password" placeholder="비밀번호를 입력하세요" required />
        </div>
        <button type="submit" class="login-btn">로그인</button>
      </form>
        <button class="login-sns" @click="kakaoLogin">
            <img src="@/assets/kakao_login_medium_wide.png" alt="카카오 로그인">
        </button>
      <br>
      <a href="/">회원가입</a>
    </div>
  </div>
</template>

<style scoped>
/* 화면 전체를 채우는 컨테이너 (중앙 정렬) */
.login-wrapper {
  display: flex;
  justify-content: center;
  align-items: center;
  min-height: 100vh;
  background-color: #f4f6f8;
}

/* 로그인 폼 카드 스타일 */
.login-card {
  width: 100%;
  max-width: 400px;
  padding: 40px;
  background-color: #ffffff;
  border-radius: 12px;
  box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);
}
.login-card h2 {
  margin-top: 0;
  margin-bottom: 24px;
  text-align: center;
  color: #333333;
}

/* 입력 그룹 */
.input-group {
  margin-bottom: 16px;
}
.input-group label {
  display: block;
  margin-bottom: 8px;
  font-weight: 500;
  color: #555555;
}
.input-group input {
  width: 100%;
  padding: 12px;
  border: 1px solid #cccccc;
  border-radius: 6px;
  box-sizing: border-box;
  font-size: 16px;
  transition: border-color 0.2s;
}
.input-group input:focus {
  border-color: #42b883;
  outline: none;
}

/* 로그인 버튼 */
.login-btn {
  width: 100%;
  padding: 14px;
  background-color: #42b883;
  color: #ffffff;
  border: none;
  border-radius: 6px;
  font-size: 16px;
  font-weight: bold;
  cursor: pointer;
  margin-top: 10px;
  transition: background-color 0.2s;
}
.login-btn:hover {
  background-color: #35495e;
}

/* sns 로그인 버튼 */
.login-sns {
  width: 100%;
  padding: 0;
  border: none;
  background: none;
  cursor: pointer;
  margin-top: 10px;
}
.login-sns img {
  display: block;
  width: 100%;
  height: auto;
}

</style>
<script setup>
import {ref} from "vue";
import axios from "axios";

const memberId = ref('')
const password = ref('')
const passwordConfirm = ref('')

//유효성 확인
function fnSignupValidation() {
  console.log('회원가입 시도:', memberId.value, password.value, passwordConfirm.value);

  if (memberId.value === '') {
    alert('아이디를 입력하세요.')
    return
  }else if(memberId.value.length > 20) {
    alert('글자수를 초과하였습니다.')
    return
  }

  if (!/^[a-z0-9]{4,20}$/.test(memberId.value)) {
    alert('아이디는 영문 소문자, 숫자만 사용하여 4~20자로 입력해주세요.')
    return
  }

  if (password.value === '') {
    alert('비밀번호를 입력하세요.')
    return
  }else if (passwordConfirm.value === '') {
    alert('비밀번호를 입력하세요.')
    return
  }

  if (!/^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*]){8,}$/.test(password.value)) {
    alert('비밀번호는 영문 대소문자, 숫자, 특수문자(!@#$%^&*)를 포함하여 8자 이상 입력해주세요.')
    return
  }

  if (password.value != passwordConfirm.value ) {
    alert('비밀번호가 일치하지 않습니다.')
    console.log(typeof passwordConfirm.value, "확인")
    console.log(typeof password.value,"비번")
    return
  }

  fnSignup()
}

//가입내용 제출
function fnSignup(){
  axios.post('/api/login', {
    memberId: memberId.value,
    password: password.value
  }
  ).then(function(response) {
    alert('회원가입 되었습니다.')
  }
  ).catch(function (error){
    alert('회원가입 실패')
    console.log(error)
  })
}
</script>

<template>
  <div class="signup-wrapper">
    <div class="signup-card">
      <h2>회원가입</h2>
      <form @submit.prevent="fnSignupValidation">
        <div class="input-group">
          <label for="memberId">아이디</label>
          <input type="text" id="memberId" v-model="memberId" placeholder="아이디를 입력하세요" required />
        </div>
        <div class="input-group">
          <label for="password">비밀번호</label>
          <input type="password" id="password" v-model="password" placeholder="비밀번호를 입력하세요" required />
        </div>
        <div class="input-group">
          <label for="passwordConfirm">비밀번호 확인</label>
          <input type="password" id="passwordConfirm" v-model="passwordConfirm" placeholder="비밀번호를 입력하세요" required />
        </div>
        <button type="submit" class="signup-btn">확인</button>
      </form>
    </div>
  </div>
</template>

<style scoped>
/* 화면 전체를 채우는 컨테이너 (중앙 정렬) */
.signup-wrapper {
display: flex;
justify-content: center;
align-items: center;
min-height: 100vh;
background-color: #f4f6f8;
}

/* 로그인 폼 카드 스타일 */
.signup-card {
width: 100%;
max-width: 400px;
padding: 40px;
background-color: #ffffff;
border-radius: 12px;
box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);
}
.signup-card h2 {
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

/* 확인 버튼 */
.signup-btn {
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
.signup-btn:hover {
  background-color: #35495e;
}

</style>
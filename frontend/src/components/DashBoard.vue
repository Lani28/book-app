<script setup>
import Login from '../components/DashBoard.vue'
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
      <router-link to="/signup">회원가입</router-link>
    </div>
  </div>
</template>

<style scoped>

</style>
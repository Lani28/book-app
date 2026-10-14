import { createRouter, createWebHistory } from 'vue-router'
import LoginHomeView from '../views/LoginHomeView.vue'
import DashBoardView from '../views/DashBoardView.vue'
import SignupView from '../views/SignupView.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'login',
      component: LoginHomeView,
    },
    {
      path: '/about',
      name: 'about',
      // route level code-splitting
      // this generates a separate chunk (About.[hash].js) for this route
      // which is lazy-loaded when the route is visited.
      component: () => import('../views/AboutView.vue'),
    },
    {
      path: '/dashboard',
      name: 'dashboard',
      component: DashBoardView,
      meta: {
        fullscreen: true
      }
    },
    {
      path: '/signup',
      name: 'signup',
      component: SignupView
    }
  ],


})

export default router

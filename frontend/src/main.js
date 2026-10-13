import './assets/main.css'

import {createApp} from 'vue'
import App from './App.vue'
import router from './router'
import axios from "axios";

const app = createApp(App)

app.use(router)

app.mount('#app')

//운영서버url
// axios.defaults.baseURL = import.meta.env.VITE_API_URL_REAL
//개발서버url
axios.defaults.baseURL = import.meta.env.VITE_API_URL_DEV
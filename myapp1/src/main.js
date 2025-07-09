import { createApp } from 'vue'
import App from './App.vue'
import router from './router'//引入路由
import store from './store'
//ui
import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'//样式库
//import '../variables.sass'

const app=createApp(App)
//use配置路由
app.use(router)
//状态管理器
app.use(store)
//ui
app.use(ElementPlus)
app.mount('#app')

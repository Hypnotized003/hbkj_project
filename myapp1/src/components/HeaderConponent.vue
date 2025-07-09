<!---页眉-->
<template>
    <el-header height="60px" class="header">
        <div class="logo">超市管理系统</div>
        <el-menu :default-active="activeIndex" mode="horizontal" @select="handleSelect">
            <el-menu-item index="1"><router-link to="/" class="nav-link">首页</router-link></el-menu-item>
            <el-menu-item index="2"><router-link to="/users" class="nav-link">用户管理</router-link></el-menu-item>
            <el-menu-item index="4"><router-link to="/GoodsView" class="nav-link">库存管理</router-link></el-menu-item>
            <el-menu-item index="3"><router-link to="/setting" class="nav-link">设置</router-link></el-menu-item>
        </el-menu>
    </el-header>
</template>
<script setup>

import { ref } from 'vue';
// import { useRoute } from 'vue-router';//保证导航栏的路由

// const router =useRoute();//保证导航栏的路由

const activeIndex = ref('1')
const handleSelect = (key) => {
    console.log('选中菜单项：', key)
}
</script>
<style scoped>
.header {
    display: flex;
    align-items: center;
    justify-content: space-between;
    background-color: #ffffff;
    box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1);
}
.nav-link {
  text-decoration: none; /* 去掉下划线 */
  color: inherit; /* 保持与父元素相同的颜色 */
}
.logo {
    font-size: 20px;
    font-weight: bold;
    margin-left: 20px;
}
</style>
<!---页面边框导航栏-->
<template>
    <el-aside width="200px" class="aside">
        <el-menu default-active="1" class="el-menu-vertical-demo">
            <el-menu-item index="1"><router-link to="/" class="nav-link">首页</router-link></el-menu-item>
            <el-menu-item index="2"><router-link to="/users" class="nav-link">用户管理</router-link></el-menu-item>
            <el-menu-item index="4"><router-link to="/inventory" class="nav-link">库存管理</router-link></el-menu-item>
            <el-menu-item index="5"><router-link to="/cartview" class="nav-link">购物车</router-link></el-menu-item>
            <el-menu-item index="6"><router-link to="/dashboard" class="nav-link">仪表盘</router-link></el-menu-item>
            <el-menu-item index="3"><router-link to="/settingview" class="nav-link">设置</router-link></el-menu-item>
        </el-menu>
    </el-aside>
</template>
<script setup></script>
<style scoped>
.aside {
    background-color: #f5f7fa;
}
.nav-link {
  text-decoration: none; /* 去掉下划线 */
  color: inherit; /* 保持与父元素相同的颜色 */
}
</style>
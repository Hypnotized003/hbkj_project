<template>
  <HeaderConponent></HeaderConponent>
  <el-container style="height: 100vh;">

    <el-container>
      <SideBar></SideBar>
      <ContentConponent></ContentConponent>
    </el-container>
  </el-container>
</template>
<script setup>
import SideBar from './components/SideBar.vue';
import HeaderConponent from './components/HeaderConponent.vue';
import ContentConponent from './components/ContentConponent.vue';
</script>
<style>
body,
html,
#app {
  margin: 0;
  padding: 0;
}
</style>
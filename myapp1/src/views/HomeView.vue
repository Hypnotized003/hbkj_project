<template>
  <div class="wrapper">
    <!-- 页面标题 -->
    <h1>超市管理系统</h1>

    <!-- 导航链接 -->
    <div class="nav-links">
      <router-link to="/about">关于我们</router-link>
    </div>

    <!-- 主页装饰内容 -->
    <div class="home-content">
      <h2>欢迎来到我们的超市管理系统！</h2>
      <p>在这里，您可以轻松管理商品信息、库存、销售记录等。</p>
      <p>系统功能丰富，操作简单，助您高效管理超市业务。</p>
    </div>
  </div>
</template>

<script>
export default {
  name: 'HomeView',
};
</script>

<style scoped>
.wrapper {
  padding: 20px;
  text-align: center;
}

h1 {
  color: #2c3e50;
  font-size: 2.5em;
  margin-bottom: 20px;
}

.nav-links {
  margin-bottom: 40px;
}

.nav-links a {
  margin: 0 10px;
  color: #42b983;
  text-decoration: none;
  font-size: 1.2em;
}

.nav-links a:hover {
  text-decoration: underline;
}

.home-content {
  margin-bottom: 40px;
}

.home-content h2 {
  color: #34495e;
  font-size: 1.8em;
}

.home-content p {
  color: #7f8c8d;
  font-size: 1.2em;
  line-height: 1.6;
}
</style>
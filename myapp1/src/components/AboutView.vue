<template>
  <div class="about-container">
    <div class="about-content">
      <h1>关于本管理系统</h1>
      <p>
        欢迎使用我们的管理系统！这是一个功能强大的工具，旨在帮助您高效地管理商品库存、进货单和销售记录。
      </p>

      <h2>主要功能</h2>
      <div class="feature-list">
        <div class="feature-card">
          <h3>商品管理</h3>
          <p>
            您可以轻松添加、编辑和删除商品信息。系统支持批量操作，方便您快速管理大量商品。
          </p>
        </div>
        <div class="feature-card">
          <h3>进货管理</h3>
          <p>
            系统提供进货单管理功能，支持自动更新库存数量。如果进货的商品已存在，系统会自动增加库存，而不是重复添加商品。
          </p>
        </div>
        <div class="feature-card">
          <h3>销售记录</h3>
          <p>
            您可以记录每笔销售的详细信息，包括商品名称、数量、单价和总价。系统会自动更新库存数量，并生成销售报表。
          </p>
        </div>
        <div class="feature-card">
          <h3>库存预警</h3>
          <p>
            系统会实时监控库存数量，当库存低于设定的阈值时，会自动提醒您及时补货。
          </p>
        </div>
        <div class="feature-card">
          <h3>数据统计与报表</h3>
          <p>
            系统提供丰富的数据统计功能，支持生成销售报表、库存报表和进货报表，帮助您更好地了解业务状况。
          </p>
        </div>
      </div>

      <h2>系统优势</h2>
      <div class="advantage-list">
        <div class="advantage-card">
          <h3>用户友好</h3>
          <p>
            界面简洁直观，操作简单易懂，即使是新手也能快速上手。
          </p>
        </div>
        <div class="advantage-card">
          <h3>高效管理</h3>
          <p>
            功能强大且灵活，支持批量操作和自动化处理，大大提高管理效率。
          </p>
        </div>
        <div class="advantage-card">
          <h3>数据安全</h3>
          <p>
            系统采用先进的数据加密技术，确保您的数据安全可靠。
          </p>
        </div>
        <div class="advantage-card">
          <h3>实时监控</h3>
          <p>
            实时监控库存和销售情况，帮助您及时做出决策。
          </p>
        </div>
      </div>

      <h2>联系我们</h2>
      <div class="contact-info">
        <p>
          如果您有任何问题或建议，请随时联系我们：
        </p>
        <ul>
          <li>邮箱：2870736305@qq.com</li>
          <li>电话：18878930475</li>
        </ul>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "AboutView",
};
</script>

<style scoped>
.about-container {
  display: flex;
  justify-content: center;
  align-items: center;
  min-height: 100vh;
  background: linear-gradient(135deg, #f7f7f7 0%, #ffffff 100%);
  color: #333;
  font-family: 'Arial', sans-serif;
}

.about-content {
  max-width: 1200px;
  padding: 40px;
  border-radius: 15px;
  background: white;
  box-shadow: 0 4px 30px rgba(0, 0, 0, 0.1);
  text-align: left;
}

h1, h2, h3 {
  color: #333;
  margin-bottom: 20px;
}

p {
  color: #666;
  line-height: 1.6;
  margin-bottom: 20px;
}

.feature-list, .advantage-list {
  display: flex;
  flex-wrap: wrap;
  gap: 20px;
}

.feature-card, .advantage-card {
  flex: 1 1 200px;
  padding: 20px;
  border-radius: 10px;
  background: #f9f9f9;
  box-shadow: 0 2px 10px rgba(0, 0, 0, 0.05);
  transition: transform 0.3s ease;
}

.feature-card:hover, .advantage-card:hover {
  transform: translateY(-10px);
}

.contact-info ul {
  list-style-type: none;
  padding: 0;
}

.contact-info ul li {
  margin-bottom: 10px;
}

@media (max-width: 768px) {
  .about-content {
    padding: 20px;
  }
}
</style>
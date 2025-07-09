<template>
    <div class="dashboard-container">
        <h1>需要补货的商品</h1>
        <el-table :data="lowStockGoods" height="500" style="width: 100%">
            <el-table-column prop="id" label="商品ID" width="220" />
            <el-table-column prop="name" label="商品名称" width="220" />
            <el-table-column prop="price" label="单价" width="220" />
            <el-table-column prop="count" label="库存数量" />
        </el-table>
    </div>
</template>

<script>
import axios from 'axios';

export default {
    name: 'DashboardView',
    data() {
        return {
            lowStockGoods: [],
        };
    },
    mounted() {
        this.getLowStockGoods();
    },
    methods: {
        async getLowStockGoods() {
                const response = await axios.get('http://127.0.0.1:8080/goods/low-stock');
                this.lowStockGoods = response.data;
        },
    },
};
</script>

<style scoped>
.dashboard-container {
    padding: 20px;
    text-align: center;
}
</style>
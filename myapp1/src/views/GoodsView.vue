<template>
    <div>
        <div class="button-group">
            <el-button type="primary" @click="getGoodsList">获取最新库存数据</el-button>
            <el-button type="primary" @click="gotoAddView">点击进货</el-button>
        </div>
        <div class="goods-table-container">
            <el-table :data="tableData" height="600" style="width: 100%">
                <el-table-column prop="id" label="商品ID" width="220" />
                <el-table-column prop="name" label="商品名称" width="220" />
                <el-table-column prop="price" label="单价" width="220" />
                <el-table-column prop="count" label="库存数量" />
                <el-table-column label="操作">
                    <template #default="scope">
                        <el-input-number v-model="scope.row.selectedQuantity" :min="0" :max="scope.row.count"
                            label="选择数量"></el-input-number>
                    </template>
                </el-table-column>
            </el-table>
            <div class="add-to-cart-button">
                <el-button type="success" @click="addToCart">添加至购物车</el-button>
            </div>
        </div>
    </div>
</template>

<script>
import { useStore } from 'vuex';
import axios from 'axios';

export default {
    name: 'GoodsView',
    data() {
        return {
            tableData: [],
        };
    },
    setup() {
        const store = useStore();
        return {
            store,
        };
    },
    mounted() {
        this.getGoodsList();
    },
    methods: {
        async getGoodsList() {
            const response = await axios.get('http://127.0.0.1:8080/goods');
            this.tableData = response.data.map(item => ({
                ...item,
                selectedQuantity: 0,
            }));
        },
        gotoAddView() {
            this.$router.push('/addview');
        },
        addToCart() {
            const cartItems = this.tableData
                .filter(item => item.selectedQuantity > 0)
                .map(item => ({
                    id: item.id,
                    name: item.name,
                    price: item.price,
                    quantity: item.selectedQuantity,
                }));

            if (cartItems.length === 0) {
                alert('请选择要添加至购物车的商品！');
            } else {
                this.store.dispatch('addCart', cartItems); // 调用 Vuex 的 action
                alert('添加成功！');
                this.$router.push('/cartview'); // 添加成功后跳转到购物车页面
            }
        },
    },
};
</script>

<style>
.button-group .el-button {
    margin-right: 50px;
    /* 按钮之间的间距 */
}
</style>
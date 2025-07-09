<template>
    <div class="button-group">
        <el-button type="primary" @click="getGoodsList">获取最新库存数据</el-button>
        <el-button type="primary" @click="gotoAddView">点击进货</el-button>
    </div>
    <el-table :data="tableData" height="600" style="width: 100%">
        <el-table-column prop="id" label="商品ID" width="220" />
        <el-table-column prop="name" label="商品名称" width="220" />
        <el-table-column prop="price" label="单价" width="220" />
        <el-table-column label="库存数量" width="220">
            <template #default="scope">
                <span :style="getStockStyle(scope.row.count)">
                    {{ scope.row.count }}
                </span>
            </template>
        </el-table-column>
    </el-table>
</template>

<script>
import axios from 'axios';

export default {
    name: 'InventoryView',
    data() {
        return {
            tableData: []
        };
    },
    mounted() {
        this.getGoodsList();
    },
    methods: {
        async getGoodsList() {
                const response = await axios.get('http://127.0.0.1:8080/goods');
                if (response.data) {
                    this.tableData = response.data.map(item => ({
                        id: item.id,
                        name: item.name,
                        price: item.price,
                        count: item.count
                    }));
                } else {
                    alert("请求失败");
                }
            
            
        },
        gotoAddView() {
            this.$router.push('/addview');
        },
        getStockStyle(count) {
            // 如果库存数量少于 50，返回红色样式
            return count < 100 ? { color: 'red' } : {};
        }
    }
};
</script>

<style>
.button-group .el-button {
    margin-right: 50px;
    /* 按钮之间的间距 */
}
</style>
<template>
    <div class="cart-container">
      <h1>购物车</h1>
      <el-table
        :data="cartItems"
        style="width: 100%"
        height="400"
      >
        <el-table-column prop="name" label="商品名称" width="220" />
        <el-table-column prop="price" label="单价" width="220" />
        <el-table-column label="数量">
          <template #default="scope">
            <el-input-number
              v-model="scope.row.quantity"
              :min="0"
              @change="updateTotalPrice"
            ></el-input-number>
          </template>
        </el-table-column>
        <el-table-column label="小计">
          <template #default="scope">
            {{ scope.row.price * scope.row.quantity }}
          </template>
        </el-table-column>
        <el-table-column label="操作">
          <template #default="scope">
            <el-button type="text" @click="removeItem(scope.row)">删除</el-button>
          </template>
        </el-table-column>
      </el-table>
  
      <div class="total-price">
        <h3>总价: {{ totalPrice }}</h3>
      </div>
  
      <div class="checkout-button">
        <el-button type="success" @click="checkout">结账</el-button>
        <el-button type="danger" @click="clearCart">清空购物车</el-button>
      </div>
    </div>
  </template>
  
  <script>
  import { computed, onMounted, ref } from 'vue';
  import { useStore } from 'vuex';
  import axios from 'axios';
  
  export default {
    name: 'CartView',
    setup() {
      const store = useStore();
      const cartItems = computed(() => store.state.cartItems || []);
      const totalPrice = ref(0);
  
      const updateTotalPrice = () => {
        totalPrice.value = cartItems.value.reduce((total, item) => total + item.price * item.quantity, 0);
      };
  
      const removeItem = (item) => {
        store.commit('removeFromCart', item.id);
        updateTotalPrice();
      };
  
      const clearCart = () => {
        store.commit('cleanCart');
        totalPrice.value = 0;
      };
  
      const checkout = () => {
        if (cartItems.value.length === 0) {
          alert('购物车为空，请添加商品！');
          return;
        }
        const stockUpdateRequests = cartItems.value.map(item => ({
          id: item.id,
          quantity: item.quantity
        }));
        axios.put('http://127.0.0.1:8080/goods/reduceStock', stockUpdateRequests)
          .then(() => {
            alert('支付成功，库存已更新！');
            clearCart();
          })
      };
      
  
      onMounted(() => {
        updateTotalPrice(); // 初始化总价
      });
  
      return {
        cartItems,
        totalPrice,
        updateTotalPrice,
        removeItem,
        checkout,
        clearCart,
      };
    },
  };
  </script>
  
  <style scoped>
  .cart-container {
    padding: 20px;
    text-align: center;
  }
  
  .total-price {
    margin: 20px 0;
    font-size: 1.5em;
    color: #2c3e50;
  }
  
  .checkout-button {
    margin-top: 20px;
  }
  </style>
<template>
    <div class="wrapper">
      <h1>HomeView</h1>
      <router-link to="/contact">联系我</router-link>
      <router-link to="/about">关于我们</router-link>
  
      <el-form label-width="auto" :model="formLabelAlign" style="max-width: 600px">
        <el-form-item label="商品id" :label-position="itemLabelPosition">
          <el-input v-model="formLabelAlign.id" />
        </el-form-item>
        <el-form-item label="商品名称" :label-position="itemLabelPosition">
          <el-input v-model="formLabelAlign.name" />
        </el-form-item>
        <el-form-item label="商品价格" :label-position="itemLabelPosition">
          <el-input v-model="formLabelAlign.price" />
        </el-form-item>
        <el-form-item label="图片" :label-position="itemLabelPosition">
          <el-input v-model="formLabelAlign.pic" />
        </el-form-item>
      </el-form>
      <el-button type="primary" @click="handleSubmit">提交</el-button>
    </div>
  </template>
  
  <script>
  import axios from 'axios';
  
  export default {
    name: 'HomeView',
    data() {
      return {
        username: '',
        tableData: [],
        formLabelAlign:{
          id:0,
          name:"",
          price:"",
          pic:""
        }
      }
    },
    methods:{
      async handleSubmit(){
        await axios.post('http://127.0.0.1:8080/goods',{
          id:this.formLabelAlign.id,
          name:this.formLabelAlign.name,
          price:this.formLabelAlign.price,
          pic:this.formLabelAlign.pic
        })
      }
    }
  }
  </script>
  
  <!-- Add "scoped" attribute to limit CSS to this component only -->
  <style scoped>
  h1 {
    color: blue;
  }
  </style>
  
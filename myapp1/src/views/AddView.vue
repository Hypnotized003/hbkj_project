<template>
    <div class="container">
      <h2>超市进货单</h2>
      <el-form
        ref="ruleFormRef"
        style="max-width: 600px"
        :model="ruleForm"
        label-width="auto"
        class="demo-ruleForm"
      >
        <el-form-item label="ID">
          <el-input v-model.number="ruleForm.id" placeholder="请输入商品ID" />
        </el-form-item>
        <el-form-item label="商品名称">
          <el-input v-model="ruleForm.name" placeholder="请输入商品名称" />
        </el-form-item>
        <el-form-item label="商品单价">
          <el-input v-model.number="ruleForm.price" placeholder="请输入商品单价" />
        </el-form-item>
        <el-form-item label="数量">
          <el-input-number v-model="ruleForm.quantity" :min="1" placeholder="请输入数量" />
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="submitForm">提交</el-button>
          <el-button @click="gotoGoodsView">返回</el-button>
        </el-form-item>
      </el-form>
    </div>
  </template>
  
  <script>
  import axios from 'axios';

  export default {
    data() {
      return {
        ruleForm: {
          id: '',
          name: '',
          price: '',
          quantity: 1,
        },
      };
    },
    methods: {
      submitForm() {
        if(!this.ruleForm.id && !this.ruleForm.name && this.ruleForm.price && !this.ruleForm.quantity){
            alert('请填写完整的进货单信息');
            return;
        }

        axios.post('http://127.0.0.1:8080/goods/addOrUpdate',{
            id:this.ruleForm.id,
            name:this.ruleForm.name,
            price:this.ruleForm.price,
            count:this.ruleForm.quantity,
            
        })
        .then(response => {
            alert('提交成功');
            this.gotoGoodsView();
            console.log('后端传递的数据:',response.data)
            this.resetForm();
        })
      },
      resetForm() {
        this.ruleForm.id = '';
        this.ruleForm.name = '';
        this.ruleForm.price = '';
        this.ruleForm.quantity = 1;
      },
      gotoGoodsView(){
        this.$router.push('/GoodsView');
      }
    },
  };
  </script>
  
  <style>
  .container {
    margin: 20px;
  }
  .demo-ruleForm {
    margin: 20px 0; /* 上下外边距为20px，左右外边距为0 */
  }
  h2 {
    margin-bottom: 20px;
  }
  </style>
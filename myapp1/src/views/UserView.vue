<template>
    <div>
      <el-button type="primary" @click="openDialog">新增用户</el-button>
      <el-button type="primary" @click="fetchUsers">刷新用户列表</el-button>
      <el-table :data="users" style="width: 100%" stripe>
        <el-table-column prop="id" label="ID" width="150"></el-table-column>
        <el-table-column label="姓名" width="150">
          <template #default="scope">
            <div v-if="!editMode || editRow !== scope.row">
              {{ scope.row.name }}
            </div>
            <el-input
              v-else
              v-model="scope.row.name"
              placeholder="请输入姓名"
            ></el-input>
          </template>
        </el-table-column>
        <el-table-column label="密码" width="150">
          <template #default="scope">
            <div v-if="!editMode || editRow !== scope.row">
              {{ scope.row.password }}
            </div>
            <el-input
              v-else
              v-model="scope.row.password"
              type="password"
              placeholder="请输入密码"
            ></el-input>
          </template>
        </el-table-column>
        <el-table-column label="权限">
          <template #default="scope">
            <div v-if="!editMode || editRow !== scope.row">
              {{ scope.row.role }}
            </div>
            <el-select
              v-else
              v-model="scope.row.role"
              placeholder="请选择身份"
            >
              <el-option label="管理员" value="admin"></el-option>
              <el-option label="普通用户" value="user"></el-option>
            </el-select>
          </template>
        </el-table-column>
        <el-table-column label="操作">
          <template #default="scope">
            <el-button
              type="text"
              size="small"
              @click="editUser(scope.row)"
              v-if="!editMode || editRow !== scope.row"
            >
              编辑
            </el-button>
            <el-button
              type="text"
              size="small"
              @click="saveUser(scope.row)"
              v-else
            >
              保存
            </el-button>
            <el-button type="text" size="small" @click="deleteUser(scope.row)">
              删除
            </el-button>
          </template>
        </el-table-column>
      </el-table>
  
      <el-dialog v-model="dialogVisible" title="新增用户">
        <el-form :model="form" label-width="80px">
          <el-form-item label="姓名">
            <el-input v-model="form.name"></el-input>
          </el-form-item>
          <el-form-item label="密码">
            <el-input v-model="form.password" type="password" show-password></el-input>
          </el-form-item>
          <el-form-item label="身份">
            <el-select v-model="form.role" placeholder="请选择身份">
              <el-option label="管理员" value="admin"></el-option>
              <el-option label="普通用户" value="user"></el-option>
            </el-select>
          </el-form-item>
        </el-form>
        <span class="dialog-footer">
          <el-button @click="dialogVisible = false">取消</el-button>
          <el-button type="primary" @click="submitForm">确定</el-button>
        </span>
      </el-dialog>
    </div>
  </template>
  
  <script setup>
  import { ref } from 'vue'
  import axios from 'axios'
  
  const users = ref([]) // 初始化为空数组，从后端获取数据
  
  const dialogVisible = ref(false) // 控制对话框显示隐藏
  const form = ref({ name: '', password: '', role: '' }) // 新增用户表单数据
  
  const editMode = ref(false) // 是否处于编辑模式
  const editRow = ref(null) // 当前编辑的行
  
  const openDialog = () => {
    dialogVisible.value = true // 打开对话框
  }
  
  const submitForm = () => {
    if (form.value.name && form.value.password && form.value.role) {
      axios.post('http://127.0.0.1:8080/user', {
        name: form.value.name,
        password: form.value.password,
        role: form.value.role,
      })
      .then(() => {
        dialogVisible.value = false // 关闭对话框
        form.value = { name: '', password: '', role: '' } // 重置表单
        fetchUsers() // 刷新用户列表
      });
    } else {
      alert('请输入姓名、密码和身份！') // 简单的表单验证提示
    }
  }
  
  const editUser = (row) => {
    editMode.value = true
    editRow.value = row
  }
  
  const saveUser = () => {
    axios.put(`http://127.0.0.1:8080/user/${editRow.value.id}`, {
      name: editRow.value.name,
      password: editRow.value.password,
      role: editRow.value.role,
    })
    .then(() => {
      editMode.value = false
      editRow.value = null
      alert('用户信息已保存！')
    });
  }
  
  const deleteUser = (row) => {
    axios.delete(`http://127.0.0.1:8080/user/${row.id}`)
    .then(() => {
      fetchUsers() // 刷新用户列表
    });
  }

  const fetchUsers = () => {
    axios.get('http://127.0.0.1:8080/user')
    .then(response => {
      users.value = response.data;
    });
  }

  // 在组件挂载时获取用户列表
  fetchUsers();
  </script>
  
  <style scoped>
  .dialog-footer {
    text-align: right;
  }
  </style>
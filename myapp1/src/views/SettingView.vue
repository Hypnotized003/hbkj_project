<template>
    <div>
        <el-card>
            <h2>设置</h2>
            <el-form :model="settings" label-width="120px">
                <el-form-item label="语⾔">
                    <el-select v-model="settings.language" placeholder="请选择">
                        <el-option label="中⽂" value="zh"></el-option>
                        <el-option label="英⽂" value="en"></el-option>
                    </el-select>
                </el-form-item>
                <el-form-item label="主题">
                    <el-select v-model="settings.theme" placeholder="请选择">
                        <el-option label="默认" value="default"></el-option>
                        <el-option label="暗⾊" value="dark"></el-option>
                    </el-select>
                </el-form-item>
                <el-form-item>
                    <el-button type="primary" @click="saveSettings">保存</el-button>
                </el-form-item>
            </el-form>
        </el-card>
    </div>
</template>
<script setup>
import { ref } from 'vue'
const settings = ref({
    language: 'zh',
    theme: 'default',
})
const saveSettings = () => {
    console.log('保存设置', settings.value)
    // 实现保存逻辑
}
</script>
<style scoped>
h2 {
    margin-bottom: 20px;
}
</style>
<template>
    <div>
        <h1>ContactView</h1>
        <p>Count:{{ count }}</p>
        <p>doubleCount:{{ doubleCount }}</p>
        <p>sanbeiCount:{{ sanbeiCount }}</p>
        <p>sibeiCount:{{ sibeiCount }}</p>
        <p>wubeiCount:{{ wubeiCount }}</p>
        <p>liubeiCount:{{ liubeiCount }}</p>
        <p>qibeiCount:{{ qibeiCount }}</p>
        <p>babeiCount:{{ babeiCount }}</p>
        <p>limitlessCount:{{ limitlessCount }}</p>
        <button @click="increment"> 增长按钮 </button>
        <h1>{{message}}</h1>
    </div>
</template>

<script>
import { mapActions, mapGetters, mapState } from 'vuex';


export default{
    name: 'ContactView',
    data(){
        return {
            
        }
    },
    // 计算属性
    computed:{
        ...mapState(['count']),//监听conut
        ...mapGetters(['doubleCount']),//获取数据
        ...mapGetters(['sanbeiCount']),
        ...mapGetters(['sibeiCount']),
        ...mapGetters(['wubeiCount']),
        ...mapGetters(['liubeiCount']),
        ...mapGetters(['qibeiCount']),
        ...mapGetters(['babeiCount']),
        ...mapGetters(['limitlessCount'])

    },
    methods:{
        ...mapActions(['increment'])//调用increment
    }
}
  
</script>

<style scoped>
    h1{
        color: red;
    }
</style>
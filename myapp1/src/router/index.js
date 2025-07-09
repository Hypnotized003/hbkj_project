import { createRouter,createWebHashHistory } from "vue-router";
import HomeView from "@/views/HomeView.vue";
import AboutView from "@/components/AboutView.vue";
import ContactView from "@/components/ContactView.vue";
import DashBoard from "@/views/DashBoard.vue";




import UserView from "@/views/UserView.vue";
import SettingView from "@/views/SettingView.vue";
import InventoryView from "@/views/InventoryView.vue";
import GoodsView from "@/views/GoodsView.vue";
import AddView from "@/views/AddView.vue";
import CartView from "@/views/CartView.vue";


const routes = [
    {
        path:'/',
        name:'Home',
        component:HomeView
    },
    {
        path:'/about',
        name:'About',
        component:AboutView
    },
    {
        path:'/contact',
        name:"Contact",
        component:ContactView
    },
    {
        path:'/dashboard',
        name:'DashBoard',
        component:DashBoard
    },
    {
        path:'/users',
        name:'Users',
        component:UserView
    },
    {
        path:'/settingview',
        name:'SettingView',
        component:SettingView
    },{
        path:'/inventory',
        name:'InventoryView',
        component:InventoryView
    },{
        path:'/goodsview',
        name:'GoodsView',
        component:GoodsView
    },{
        path:'/addview',
        name:'AddView',
        component:AddView
    },{
        path:'/cartview',
        name:'CartView',
        component:CartView
    }
]

const router = createRouter({
    history:createWebHashHistory(),
    routes
})

router.beforeEach((to,from,next)=>{
    if(to.name=="About"){
        console.log("进入到about页面")
    }
    next()
})

export default router
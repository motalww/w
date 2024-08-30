import Vue from 'vue'
import VueRouter from 'vue-router'

Vue.use(VueRouter)

const routes = [
  {
    path: '',
    name: 'Main',
    redirect:'/first',//重定向
    component:()=>import('../views/Main.vue'),
    children:[
        {path:'/my',name:'My',component:()=>import('../components/My.vue'),},
        {path: '/info',name:'Info',component:()=>import('../components/Info.vue')},
        {path:'/first',name:'First',redirect:'/aView',component:()=>import('../components/First.vue'),
        children:[
            {path:'/aView',name:'view',component:()=>import('../components/aView.vue')},
            {path:'/restaurant',name:'Restaurant',component:()=>import('../components/Restaurant.vue')},
            {path:'/hotel',name:'Hotel',component:()=>import('../components/Hotel.vue')},
            {path:'/line',name:'Line',component:()=>import('../components/Line.vue')},
        ]},
        {path:'/register',name:'Register',component:()=>import('../components/register.vue')},
        {path:'/maptest',name:'MapTest',component:()=>import('../components/Maptest.vue')},
        {path: '/AreaView',name:'AreaView',component:()=>import('../components/AreaView.vue')},
        {path: 'HotelView',name:'HotelView',component:()=>import('../components/HotelView.vue')},
        {path: '/RestaurantView',name:'RestaurantView',component:()=>import('../components/RestaurantView.vue')},
        {path: '/secmap',name:'SecMap',component:()=>import('../components/SecMap.vue')},
        {path:'/login', name:'Login', component:()=>import('../components/Login.vue')},
    ]
  },
    {
        path: '/maptest',
        name:'Maps',
        component:()=>import('../components/Maptest.vue')
    }
]

const router = new VueRouter({
  mode:"history",
  routes
})
//解决重复点击报错
const VueRouterPush = VueRouter.prototype.push
VueRouter.prototype.push = function push (to) {
  return VueRouterPush.call(this, to).catch(err => err)
}
export default router

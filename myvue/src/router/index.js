  import Vue from 'vue'
import VueRouter from 'vue-router'

Vue.use(VueRouter)

const routes = [
  {
    path: '/login',
    name: 'Login',
     component:()=>import("../views/Login.vue")
  },
  {
    path: '/',
    name:'Manage',
    component:()=>import("../views/Manage.vue"),
    redirect:"/user", //输入‘/’重定向到home
    //子路由
    children:[
      {path:'home',name:'Home',component:()=>import("../views/HomeView.vue")},
      {path:'user',name:'User',component:()=>import("../components/User.vue")},
      {path: 'area',name:'Area',component:()=>import("../components/Area.vue")},
      {path: '/comment',name:'Content',component:()=>import('../components/Comment.vue')},
      {path: '/hotel',name:'Hotel',component:()=>import('../components/Hotel.vue')},
      {path: '/restaurant',name:'Restaurant',component:()=>import('../components/Restaurant.vue')},
      {path: '/line',name:'Line',component:()=>import('../components/Line.vue')}
    ]
  }
]

const router = new VueRouter({
  mode:"history",
  routes
})

export default router


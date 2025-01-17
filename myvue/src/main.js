import Vue from 'vue'
import App from './App.vue'
import router from './router'
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
import request from "../utils/request";

Vue.config.productionTip = false

Vue.use(ElementUI,{size:"mini"});

Vue.prototype.request=request //使用axios
Vue.prototype.$baseUrl=process.env.VUE_APP_BASEURL

new Vue({
  router,
  render: h => h(App)
}).$mount('#app')

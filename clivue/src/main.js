import Vue from 'vue'
import App from './App.vue'
import router from './router'
import 'mint-ui/lib/style.css'
import MintUI from 'mint-ui'
import request from "../utils/request";
import LyTab from 'ly-tab';

import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';


Vue.use(LyTab);

Vue.use(ElementUI,{size:"mini"});
Vue.use(MintUI)


Vue.prototype.request=request //使用axios

Vue.config.productionTip = false

new Vue({
  router,
  render: h => h(App)
}).$mount('#app')

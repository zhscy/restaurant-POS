// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import ElementUI from 'element-ui' //新添加
import 'element-ui/lib/theme-chalk/index.css' //新添加,避免后期打包样式不同，要放在import App from './App';之前
import Vue from 'vue'
import App from './App'//导入App组件
import router from './router'

//引入axios，解决跨域传带cookie
import axios from 'axios' //引入axios
axios.defaults.withCredentials = true; //跨域请求  带上cookie  这样每次发送ajax请求后，只要不关闭浏览器，得到的session数据都是一致的。
Vue.prototype.$axios = axios; //添加axios到Vue的原型对象上


Vue.use(ElementUI)   //新添加
Vue.config.productionTip = false

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  components: { App },
  template: '<App/>'
})

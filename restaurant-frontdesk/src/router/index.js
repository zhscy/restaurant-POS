import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import Home from '@/components/Home'//新添加，之后在下方的component: Home才会生效
import appetizer from '@/components/appetizer'
import soup from '@/components/soup'
import mainCourse from '@/components/mainCourse'
import pasta from '@/components/pasta'
import dessert from '@/components/dessert'
import drinks from '@/components/drinks'
import setMeal from '@/components/setMeal'

Vue.use(Router)//明确安装路由

export default new Router({
	mode: 'history',
	scrollBehavior: () => ({
    y: 0
  }),
	routes: [ //一组路由
		
    {
			path: '/',  //一级路由   根路径，打开页面即显示Home页面,也可打开Helloword然后跳转到 Home
			//name: 'HelloWorld',
			component: Home,
			children: [  //嵌套子路由,路由出口为Home中的router-view
				{ path: 'appetizer', component: appetizer },
				{ path: 'soup', component: soup },
				{ path: 'mainCourse', component: mainCourse },
				{ path: 'pasta', component: pasta},
				{ path: 'dessert', component: dessert },
				{ path: 'drinks', component: drinks},
				{ path: 'setMeal', component: setMeal }
			] 
 
		},
	
  ]
})

<template>
    <!-- 这里router-link to="home"会把路由导航到http://localhost:8080/#/home   -->
    <router-link to="home"><h1>{{ msg }}</h1></router-link>
</template>

<script>
export default {
  name: 'HelloWorld',
  data () {
    return {
      msg: '欢迎光临，请点餐'
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style>
h1{
  font-weight: normal;
}
a {
	color:#42b983;
	text-decoration: none;
}
</style>

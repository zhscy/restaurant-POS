import axios from 'axios'
//设置基地址
axios.defaults.baseURL='http://localhost/pos'
axios.defaults.timeout = 5000
axios.defaults.header = {'Content-Type': 'application/json;'}

//接口
export const getCategoryList = param => { return axios.post('/getCategoryList', param).then(res => res) }

export const getMenuList = param => { return axios.post('/getMenuList', param).then(res => res) }

export const getTableList = param => { return axios.post('/getTableList', param).then(res => res) }

export const getPayOrderItems = param => { return axios.post('/getItemList', param).then(res => res) }

export const submitOrder = param => { return axios.post('/submitOrder', param).then(res => res)}

export const payOrderList = param => { return axios.post('/payOrderList', param).then(res => res)}

export const getItemList = param => { return axios.post('/getItemList', param).then(res => res)} //获取订单详情

export const pay = param => { return axios.post('/pay', param).then(res => res)}

// export const test = axios.post('/test').then(res => res)

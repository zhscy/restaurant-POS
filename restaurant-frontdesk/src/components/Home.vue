<template>
	<el-row>
		<!--Tabs标签页-->
		<template>
	  	<el-tabs type="border-card" style="margin-top: -50px;">
		    <el-tab-pane><span slot="label"><i class="el-icon-menu"></i> 点餐</span>

		      <!--Tabs点餐页面内容-->
		    	<el-container style="height: 530px; border: 2px solid #eee">
            <el-aside  width="200px" >
					  	<el-menu class="el-menu-vertical-demo">
										<el-menu-item-group v-for="category in categoryList" :key="category.value">
											<el-menu-item v-on:click="getMenus(category.ctgId)">{{ category.ctgName }}</el-menu-item>
										</el-menu-item-group>

                <!-- <el-menu-item index="category" v-for="category in categoryList" :key="category.value">
                  <template slot="title" ><i class="el-icon-menu"></i>{{ category.ctgName }}</template>
                </el-menu-item> -->
              </el-menu>
			      </el-aside>
			
						<el-container style="width:60px;height: 600px; border: 1px solid #eee">
							<el-main>
							<!--列表   表头颜色   :header-cell-style="{background:'#EBEEF5'}"-->
							<el-table :data="menuList" :header-cell-style="{background:'#EBEEF5'}" highlight-current-row height="500" style="width: 100%;">
								<el-table-column prop="menuName" label="菜品" width="350">
								</el-table-column>
								<el-table-column prop="menuId" label="菜品id" width="120" v-if="false"></el-table-column>
								<el-table-column prop="menuPrice" label="价格" width="120">
								</el-table-column>
								<el-table-column label="操作" width="100">
									<template slot-scope="scope">
										<el-button size="small" icon="el-icon-circle-plus-outline" @click="addRow(scope.$index, scope.row)" circle></el-button>
									</template>
								</el-table-column>
							</el-table>
							</el-main>
						</el-container>

						<el-container style="width:200px;height:510px; border: 1px solid aliceblue">
							<el-main>
								<!-- 订单明细  -->
								<el-table :data="salesItem" :header-cell-style="{background:'#EBEEF5'}" highlight-current-row style="width: 100%;">
									<el-table-column prop="menu" label="订单详情" width="240"><!--显示菜品名-->
									</el-table-column>
									<el-table-column prop="itemMenuId" label="菜品id" width="50" v-if="false">
									</el-table-column>
									<el-table-column prop="unitPrice" label="单价" width="80">
									</el-table-column>
									<el-table-column prop="itemAmount" label="数量" width="50">
									</el-table-column>
									<el-table-column prop="totalPrice" label="小计" width="80">
									</el-table-column>

									<el-table-column prop="itemHandle" width="200" label="操作备注">
										<template slot-scope="scope">
											<el-input	v-model="scope.row.itemHandle"	type="text"	placeholder="请输入内容"	@keyup.esc.native="cancel(scope.$index, scope.row)">
											</el-input>
										</template>
									</el-table-column>

									<el-table-column  width="100">
										<template slot-scope="scope">
											<!-- <el-button type="primary" size="mini" @click="remarkFormVisible = true">备注</el-button>												
												<el-dialog title="备注" :visible.sync="remarkFormVisible" width="30%">
													<el-form :model="form">
													<el-form-item label="" >
														<el-input type="textarea" :rows="2" v-model="form.remark" placeholder="请输入备注"></el-input>
													</el-form-item>
													</el-form>
													<div slot="footer" class="dialog-footer">	
														<el-button size="small" @click="remarkFormVisible = false">取 消</el-button>
														<el-button size="small" type="primary" @click="remarkFormVisible = false">确 定</el-button>
													</div>
												</el-dialog> -->
												<!-- 删除 增加 图标 -->
											<el-button size="mini" icon="el-icon-circle-plus-outline" @click="add(scope.$index, scope.row)" circle></el-button>
											<el-button size="mini" icon="el-icon-remove-outline" @click="del(scope.$index, scope.row)" circle></el-button>
										</template>
									</el-table-column>
								</el-table>

							<!-- <div class="summarize">
									<small>数量：</small>{{totalAmount}}
									<small>总计：</small>{{orderTotalPrice}}
              </div> -->

							</el-main>
				
							<el-footer>
								<el-form :inline="true" > <!--设置 inline 属性可以让表单域变为行内的表单域-->
									<!-- 选桌 -->
										<el-form-item label="餐桌号">
											<el-select v-model="orderTable" placeholder="选桌" style="width:110px;margin-right:50px;" >
												<el-option v-for="dinnerTable in tableList" :key="dinnerTable.value" :label="dinnerTable.dinnerNumber" :value="dinnerTable.dinnerId"></el-option>
											</el-select>
										</el-form-item>	

									<!--时间-->
									<!-- <el-form-item>
										<span style="margin-left:20px;"><i class="el-icon-time"></i></span>
										<span style="margin-right: 50px;margin-left: 5px;">{{ nowTime }}</span>  
									</el-form-item> -->

									<el-form-item>
										<el-button size="small" type="primary" @click="submitSaleItems">挂单</el-button>
									</el-form-item>
									
									</el-form>		
									
							</el-footer>
					  </el-container>	
					
					</el-container>
		
				</el-tab-pane>


				<el-tab-pane><span slot="label"><i class="el-icon-tickets" @click="getPayList(orderId,tableId)"> 结账</i>  </span>
					<!--Tabs结账页面内容-->		
					<el-container style="width:100%; height: 800px; border: 2px solid #eee">
					<!--查询订单-->
						<template>
							<section>
								<el-col :span="20"  style="padding-top: 20px;">
									<el-form :inline="true" > <!--设置 inline 属性可以让表单域变为行内的表单域-->
										<el-form-item>
											<el-input v-model="orderId" placeholder="请输入订单号"></el-input>
										</el-form-item>
										<el-form-item>
											<el-select :data="tableList" v-model="tableId" placeholder="选桌" style="width:110px;margin-right:50px;" >
												<el-option v-for="dinnerTable in tableList" :key="dinnerTable.value" :label="dinnerTable.dinnerNumber" :value="dinnerTable.dinnerId"></el-option>
											</el-select>
										</el-form-item>
										<el-form-item>
											<el-button type="primary" size="medium" :model="orderList" @click="getPayList(orderId,tableId)"><i class="el-icon-search">查询</i></el-button>
										</el-form-item>
									</el-form>		
								</el-col>

								<el-table :data="orderList" :header-cell-style="{background:'#EBEEF5'}" border height="500" style="width:80%; margin-left:80px;">
				
									<el-table-column label="日期时间" sortable prop="orderTime" width="260">		
									</el-table-column>
									<el-table-column label="订单号" prop="orderId" width="160">
									</el-table-column>
									<el-table-column label="桌号" prop="table" width="160">
									</el-table-column>
									<el-table-column label="总价" prop="orderTotalPrice" width="160">
									</el-table-column>	
									<el-table-column label="操作" width="280">
										<template slot-scope="scope">					             
											<!-----------------------------------------------------注意不是scope.rows-->
											<el-button type="warning" size="small" @click="pay(scope.$index, scope.row)">付款</el-button>
				                                <el-dialog title="付款" :visible.sync = "payFormVisible" width="30%" center>
					                                <el-form :model="form" >
					                                <el-form-item label="订单编号:" :label-width="formLabelWidth">{{form.orderId}}  
					                                </el-form-item>
					                                <el-form-item label="应付金额:" :label-width="formLabelWidth">{{form.orderTotalPrice}}
					                                </el-form-item>
					                                <el-form-item label="支付方式" :label-width="formLabelWidth">
					                                  <el-select v-model="form.payWay" placeholder="请选择支付方式">
					                                    <el-option label="现金" value="0"></el-option>
					                                    <el-option label="微信/支付宝" value="1"></el-option>
					                                  </el-select>
					                                </el-form-item>                     
					                                <el-form-item label="实付金额" :label-width="formLabelWidth">
					                                  <el-input v-model="form.payTotal" placeholder="请输入金额"></el-input>
					                                </el-form-item>
					                                <el-form-item label="找零:" :label-width="formLabelWidth">{{showChange}}
					                                </el-form-item>                         
					                                </el-form>
					                                
												<div slot="footer" class="dialog-footer">
						                            <el-button size="small" @click="payFormVisible = false">取 消</el-button>
					                                <el-button size="small" type="primary" @click="submitPay">确 定</el-button>
												</div>
					                            </el-dialog>          				
													
											<el-button type="primary" size="small" @click="getOrderDetails(scope.$index, scope.row)">订单详情</el-button>
                        
												<el-dialog title="订单详情"  :visible.sync="orderDetailsFormVisible" center>  
													<el-table :data="itemList" >
														<el-table-column prop="menu" label="菜品名称" width="260">
														</el-table-column>														
														<el-table-column prop="itemAmount" label="数量" width="150">
														</el-table-column>														
														<el-table-column prop="unitPrice" label="单价" width="160">
														</el-table-column>														
														<el-table-column prop="totalPrice" label="总价" width="180">
														</el-table-column>														
													</el-table>

													<div slot="footer" class=dialog-footer>
													  <!-- <el-button size="small" @click="orderDetailsFormVisible = false">取消</el-button> -->
													  <el-button size="small" type="primary" @click="orderDetailsFormVisible = false">确定</el-button>
													</div>
												</el-dialog>
                        
										</template>
									</el-table-column>

								</el-table>
		        	</section>
	        	</template>
					</el-container>
					
					
				</el-tab-pane>
      </el-tabs>
		</template>	
  </el-row>
</template>


<script>

import { getCategoryList } from '../api/api.js'
import { getMenuList } from '../api/api'
import { getTableList } from '../api/api'
import { payOrderList } from '../api/api'
import { submitOrder } from '../api/api'
import { getPayOrderItems } from '../api/api'
import { getItemList } from '../api/api'
import { pay } from '../api/api'

export default {
  name: "Home",
  component:{},
  data(){
    return {
			categoryList: [], // 菜品类别列表
			menuList: [], // 菜品列表
			tableList: [], // 餐桌列表
			salesItem: [],  // 下单明细
			orderList: [], // 未付订单
			itemList: [], // 订单详情

			remarkFormVisible: false,//备注界面是否显示
			payFormVisible: false,//付款界面是否显示
			orderDetailsFormVisible: false,//订单详情界面是否显示

			orderId:'', // 查询订单id
			tableId: '', // 查询订单餐桌号
			orderTable:'', // 挂单的餐桌
			// totalAmount:'',
			// orderTotalPrice: '',
			// itemAmount: 0,
			// totalPrice: 0,
			textarea:'',
			nowTime: '',
			num: 1,
			
			form: {
				orderId: '',
				orderTotalPrice: '',
				payTotal: '', // 总付金额
				change: '', // 找零
				payWay: '',
				// total: '',
				// remark: '',
			},
			
			formLabelWidth: '100px'

    }
	},
	
	
	
 // 挂载完成时
   mounted() {
		this.getData()
		// console.log('mounted')
    this.nowTimes();
	},

	// 计算找零
	computed: {
		showChange : function () {
				this.form.change =  this.form.payTotal - this.form.orderTotalPrice
				if (this.form.change >= 0) {
					return this.form.change
				} else {
					return ''
				}
		}
	},

  methods: {
		// 挂单
		submitSaleItems () {
			let data = {'itemList': this.salesItem, 'order': {'tableId': this.orderTable}}
			let _this = this
			console.log(data)
			submitOrder (data)
        .then(res => {
          if (res.status === 200) {

						// 挂单处理，res.data.code 0-成功，1-失败 res.data.msg为返回消息
						if (res.data.code == 0) {
							console.log(res.data.msg)
							//消息提示
							this.$message({
								message: res.data.msg,
								type: 'success'
							})

							_this.salesItem = []
							_this.orderTable = ''
						} else { 
							console.log(res.data.msg)
							
							this.$message({
								message: res.data.msg,
								type: 'warning'
							})

						}
          } else {
            console.log(res)
          }
        })
        .catch(error => {
          console.log('error' + error)
        })
		},


    //查看订单详情
    getOrderDetails(index, rows) {
			this.orderDetailsFormVisible = true
			// console.log('订单号' + rows.orderId)
			let data = {'orderId': rows.orderId}
			// console.log(data)
			getItemList (data)
						.then(res => {
							if (res.status === 200) {
								// console.log('成功获取订单详情')
								this.itemList = res.data
								// console.log(this.itemList)
							} else {
								console.log(res)
							}
						})
						.catch(error => {
							console.log('error' + error)
						})
					
		},

		// 获取未支付的订单
		getPayList (orderId, tableId) {
			let data = {'orderId': orderId, 'tableId': tableId}
			console.log(data)
			payOrderList (data)
        .then(res => {
          if (res.status === 200) {
            // console.log('success')
						this.orderList = res.data
						// console.log(this.orderList)
          } else {
            console.log(res)
          }
        })
        .catch(error => {
          console.log('error' + error)
        })
		},

		//付款
		pay(index, rows) {
			this.payFormVisible = true
			this.form.orderId = rows.orderId
			this.form.orderTotalPrice = rows.orderTotalPrice
		  
		},
		//提交付款
		submitPay() {

			let data = {'payment': {'payTime':new Date(), 'payWay': this.form.payWay, 'payTotal': this.form.payTotal, 'payChange': this.form.change, 'payActual': this.form.orderTotalPrice}, 'order': {'orderId': this.form.orderId}}
			
			pay (data)
        .then(res => {
          if (res.status === 200) {
						if (res.data.code == 0) {
							// console.log(res.data.msg)
							this.$message({
								message: res.data.msg,
								type: 'success'
							})
							
							this.form.payTotal = ''
							this.form.payWay = ''
							this.form.change = ''

							setTimeout(this.getPayList, 2000)

						} else { 
							// console.log(res.data.msg)							
							this.form.payTotal = ''
							this.form.payWay = ''
							this.form.change = ''

							this.$message({
								message: res.data.msg,
								type: 'warning'
							})
						}
          } else {
            console.log(res)
          }
        })
        .catch(error => {
					console.log('error' + error)
					this.$message({
								message: '发生错误',
								type: 'error'
							})
				})
				
			this.payFormVisible = false
		},

		// 类别下对应的菜品
		getMenus (ctgId) {
			let data = {'ctgId': ctgId}
			// console.log(data)
			getMenuList (data)
        .then(res => {
          if (res.status === 200) {
            // console.log('success')
						this.menuList = res.data
						// console.log(this.menuList)
          } else {
            // confirm('else')
            console.log(res)
          }
        })
        .catch(error => {
          console.log('error' + error)
        })
		},


		getData () {
			//获取类别
      getCategoryList()
        .then(res => {
          if (res.status === 200) {
            // console.log('success')
						this.categoryList = res.data
						// console.log(this.categoryList)
          } else {
            console.log(res)
          }
        })
        .catch(error => {
          console.log(error)
				})

			// 获取餐桌
			getTableList ()
				.then(res => {
					if (res.status === 200) {
					// console.log('success')
					this.tableList = res.data
					// console.log(this.tableList)
				} else {
					console.log(res)
				}
				})
				.catch(error => {
				console.log(error)
			})
				
    },


		// 获取当前时间函数
    timeFormate(timeStamp) {
      let year = new Date(timeStamp).getFullYear();
      let month =new Date(timeStamp).getMonth() + 1 < 10? "0" + (new Date(timeStamp).getMonth() + 1): new Date(timeStamp).getMonth() + 1;
      let date =new Date(timeStamp).getDate() < 10? "0" + new Date(timeStamp).getDate(): new Date(timeStamp).getDate();
      let hh =new Date(timeStamp).getHours() < 10? "0" + new Date(timeStamp).getHours(): new Date(timeStamp).getHours();
      let mm =new Date(timeStamp).getMinutes() < 10? "0" + new Date(timeStamp).getMinutes(): new Date(timeStamp).getMinutes();
      let ss =new Date(timeStamp).getSeconds() < 10? "0" + new Date(timeStamp).getSeconds(): new Date(timeStamp).getSeconds();
      // return year + "年" + month + "月" + date +"日"+" "+hh+":"+mm ;
      this.nowTime = year + "-" + month + "-" + date +" "+hh+":"+mm + ":" + ss;
			// console.log(this.nowTime);
			// console.log('定时器');
    },
    // 定时器函数,每秒更新一次
    nowTimes(){
      this.timeFormate(new Date());
			// setInterval(this.nowTimes,1000);
			// this.clear()
		},

		//清除定时器
		clear(){
			clearInterval(this.nowTimes)
			this.nowTimes = null;
		},
		
  	created: function () {
    	this.getData()
    	console.log('created')
  
		},
		
		//添加菜品到订单明细表  ,index表示第几行，rows是那一行的数据
		addRow(index, rows) {   //this指data里的变量
			let data = this.salesItem.filter(r => r.menu == rows.menuName) //过滤,判断添加的菜品是否已添加rows
			if(data.length > 0) {  //已经存在则+1，否则新建
				data[0].itemAmount++
				data[0].totalPrice = data[0].unitPrice * data[0].itemAmount
			} else {
				let newMenu = { menu:rows.menuName, itemMenuId:rows.menuId, unitPrice:rows.menuPrice, itemAmount:1, totalPrice:rows.menuPrice }
				this.salesItem.push(newMenu)
			}
			
			
		},
		add(index, rows) {
			rows.itemAmount++
		},
		//删除订单列表行数据
		del(index, rows){
			if( rows.itemAmount>1) {
			rows.itemAmount--
			} else {
				this.salesItem.splice(index, 1)//删除点击的对象
			}
		},

	},
	

  watch:{  //watch是vue的监听，一旦监听对象有变化就会执行相应操作
    tabledata:{  //被监听的对象
      handler(items){Storage.save(items)},  //监听对象变化后所做的操作，一个函数，保存数据
      deep: true  //深度监听，避免数据的嵌套层数太多，要使用深度监听，防止数据层级过多监听不到
    },

  }
}



</script>
<style>
	
	a {
		color: #333333;
		text-decoration: none;
	}
	
	.el-header {
    background-color: #B3C0D1;
    color: #333;
    line-height: 60px;
  }
  
  .el-aside {
    color: #333;
  }
	
    #main{
      float: none;
      margin: 0 auto;
  }
  .el-input{
    padding-bottom: 5px;
  }
  .el-select {
      display: block;
  }
  .btn-auto{
      width: 100%;
      margin-top: 12px;
  }

	.summarize {
		text-align: center;
    padding: 15px;
    border-bottom: 1px solid #E5E9F2;
	}
	.summarize small {
    margin-left: 40px;
}

</style>
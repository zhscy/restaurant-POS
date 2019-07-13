<template>
	<section>
		<!--列表   :data="appetizer"   表头颜色   :header-cell-style="{background:'#EBEEF5'}"-->
		<el-table  :header-cell-style="{background:'#EBEEF5'}" highlight-current-row height="500" style="width: 100%;">
			<el-table-column prop="menuName" label="菜品" width="200">
			</el-table-column>
			<el-table-column prop="menuImage" label="图片" width="150">

			</el-table-column>
			<el-table-column prop="menuPrice" label="价格" width="90">
			</el-table-column>
			<el-table-column label="操作" width="70">
				<template slot-scope="scope">
					<el-button size="small" icon="el-icon-circle-plus-outline" @click="add(scope.row)" circle></el-button>
				</template>
			</el-table-column>
		</el-table>

		
	</section>
</template>

<script>

	export default {
		data() {
			return {
				filters: {
					name: ''
				},
				tableData: [{
            name: '牛排',
			image: '',
            price: '50.20'
          }, 
		  {
            name: '牛排2',
            image: '',
            price: '96.00'
          }, 
		  {
            name: '橙汁',
            image: '',
            price: '15.00'
          },
		  {
		    name: '肉酱意大利面',
		    image: '',
		    price: '18.00'
		  },
		  {
		    name: '草莓酸奶沙拉',
		    image: '',
		    price: '16.00'
		  },
		  {
            name: '菇香牛肉意大利面',
            image: '',
            price: '28.00'
          }],
				total: 0,
				page: 1,
			
				sels: [],//列表选中列

			
			}
		},
		methods: {
			//增加到订单
         addRow(index, rows) {
						 //先将订单号
						 this.menuName=rows.muneName
						 this.itemAmount=rows.itemAmount
             this.orderID=rows.orderID
             console.log('获得订单号并传值到后台')
             console.log(this.orderID)
            //获取房间表列
             this.findList ()
          //获取订单号及其中的信息，并获取具体房间号并返回
           this.InfoVisable=true
           
           },
			
	},
	}

</script>

<style scoped>

</style>
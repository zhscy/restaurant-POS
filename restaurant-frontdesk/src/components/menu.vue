<template>
	<section>
		<!--列表   表头颜色   :header-cell-style="{background:'#EBEEF5'}"-->
		<el-table :data="menuList" :header-cell-style="{background:'#EBEEF5'}" highlight-current-row height="500" style="width: 100%;">

			<!-- 隐藏显示menuId -->
			
			<el-table-column prop="menuName" label="菜品" width="200">
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
				menuList: [],
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
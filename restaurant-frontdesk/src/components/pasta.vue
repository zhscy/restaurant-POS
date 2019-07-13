<template>
	<section>
		<!--列表                     表头颜色   :header-cell-style="{background:'#EBEEF5'}"-->
		<el-table :data="tableData" :header-cell-style="{background:'#EBEEF5'}" highlight-current-row  height="500" style="width: 100%;">
		<!--只要在el-table元素中定义了height属性，即可实现固定表头的表格，而不需要额外的代码。-->
			<el-table-column prop="name" label="菜品" width="200">
			</el-table-column>
			<el-table-column prop="image" label="图片" width="150">
				<!--插入图片链接的代码-->
            <template slot-scope="scope">
              <!--<img  :src="scope.row.main_pic" alt="" class="main_pic" style="width: 80px;height: 80px">-->
			  <img src="../assets/guxiang.png" alt=""style="width: 80px;height: 80px">
            </template>

			</el-table-column>
			<el-table-column prop="price" label="价格" width="90">
			</el-table-column>
			<el-table-column label="操作" width="70">
				<template slot-scope="scope">
					<el-button size="small" icon="el-icon-circle-plus-outline" @click="handleAdd" circle></el-button>
				</template>
			</el-table-column>
		</el-table> 
		
	</section>
</template>

<script>

	export default {
		data() {
			return {
			
		
				tableData: [
		  {
		    name: '肉酱意大利面',
		    image: '',
		    price: '18.00'
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
			handleAdd: function (index, row) {
				
			},
		
			
	},
	}

</script>

<style>
.main_pic {
	
}
</style>
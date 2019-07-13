<template>
	<section>
		<!--列表                     表头颜色   :header-cell-style="{background:'#EBEEF5'}"-->
		<el-table :data="menu" :header-cell-style="{background:'#EBEEF5'}" highlight-current-row  height="500" style="width: 100%;">
		<!--只要在el-table元素中定义了height属性，即可实现固定表头的表格，而不需要额外的代码。-->
			<el-table-column prop="menuName" label="菜品" width="200">
			</el-table-column>
			<el-table-column prop="menuImage" label="图片" width="150">
				<!--插入图片链接的代码-->
				<img src="../assets/steak.png" alt="" style="width: 80px;height: 80px">

			</el-table-column>
			<el-table-column prop="menuPrice" label="价格" width="90">
			</el-table-column>
			<el-table-column label="操作" width="70">
				<template slot-scope="scope">
					<el-button size="small" icon="el-icon-circle-plus-outline" @click="addMenu(scope.$index, scope.row)" circle></el-button>
				</template>
			</el-table-column>
		</el-table>

		
	</section>
</template>

<script>

	export default {
		data() {
			return {
				menu: [
					{
						menuImage: ''
					},
					],
			
			}
		},
		methods: {
			//增加菜品到订单列表
			addMenu(index, row) {
				
			},
			
	},
	}

</script>

<style scoped>

</style>
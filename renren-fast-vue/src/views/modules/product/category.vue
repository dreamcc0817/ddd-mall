<template>
  <el-tree
    :data="menus"
    :props="defaultProps"
    @node-click="handleNodeClick"
    :expand-on-click-node="false"
    :default-expanded-keys="expandedKey"
    show-checkbox
    node-key="catId"
  >
    <span class="custom-tree-node" slot-scope="{ node, data }">
      <span>{{ node.label }}</span>
      <span>
        <el-button
          v-if="node.level <= 2"
          type="text"
          size="mini"
          @click="() => append(data)"
        >
          Append
        </el-button>
        <el-button
          v-if="node.childNodes.length == 0"
          type="text"
          size="mini"
          @click="() => remove(node, data)"
        >
          Delete
        </el-button>
      </span>
    </span>
  </el-tree>
</template>

<script>
export default {
  //import 引入的组件需要注入到对象中才能使用
  components: {},
  props: {},
  data() {
    //这里存放数据
    return {
      menus: [],
      defaultProps: {
        children: "children",
        label: "name",
      },
    };
  },
  //计算属性 类似于 data 概念
  computed: {},
  //监控 data 中的数据变化
  watch: {},
  //方法集合
  methods: {
    handleNodeClick() {
      console.log("success", this.data);
    },
    getMenus() {
      this.$http({
        url: this.$http.adornUrl("/product/category/getAssermblyCategory"),
        method: "get",
      }).then(({ data }) => {
        console.log("success", data);
        this.menus = data.result;
      });
    },
    remove(node, data) {
      var ids = [data.catId];
      this.$confirm(`是否删除【${data.name}】菜单?`, "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning",
      }).then(() => {
        this.$http({
          url: this.$http.adornUrl("/product/category/deleteCategory"),
          method: "post",
          data: this.$http.adornData(ids, false),
        }).then(({ data }) => {
          this.$message({
            message: "菜单删除成功",
            type: "success",
          });
          //刷新出新的菜单
          this.getMenus();
          //设置需要默认展开的菜单
          this.expandedKey = [node.parent.data.catId];
        }).catch(
          () => {}
        );
      });
    },
  },
  //生命周期 - 创建完成（可以访问当前 this 实例）
  created() {
    this.getMenus();
  },
  //生命周期 - 挂载完成（可以访问 DOM 元素）
  mounted() {},
  beforeCreate() {}, //生命周期 - 创建之前
  beforeMount() {}, //生命周期 - 挂载之前
  beforeUpdate() {}, //生命周期 - 更新之前
  updated() {}, //生命周期 - 更新之后
  beforeDestroy() {}, //生命周期 - 销毁之前
  destroyed() {}, //生命周期 - 销毁完成
  activated() {}, //如果页面有 keep-alive 缓存功能，这个函数会触发
};
</script>
<style lang='scss' scoped>
//@import url(); 引入公共 css 类
</style>
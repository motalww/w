<template>
  <div >
    <div style="width: 100%">
      <mt-search style="width: 100%"
                 v-model="value"
                 cancel-text="取消"
                 placeholder="搜索">
      </mt-search>
    </div>
  </div>
</template>

<script>

export default {
  name: 'HomeView',

}
</script>

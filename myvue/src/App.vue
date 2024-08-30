<template>
  <div>
<router-view/>
  </div>
</template>

<script>
const debounce = (fn, delay) => {
  let timer
  return (...args) => {
    if (timer) {
      clearTimeout(timer)
    }
    timer = setTimeout(() => {
      fn(...args)
    }, delay)
  }
}

const _ResizeObserver = window.ResizeObserver;
window.ResizeObserver = class ResizeObserver extends _ResizeObserver{
  constructor(callback) {
    callback = debounce(callback, 200);
    super(callback);
  }
}

import Manage from "@/views/Manage.vue";

export default {
  components: {Manage},
  data(){
    return{
    }
  },
  methods:{

  }
}
</script>
<style>

</style>

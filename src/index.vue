<template>
  <div>
    <home-view></home-view>
  </div>
</template>

<style>
</style>

<script>
  import HomeView from './views/HomeView.vue'
  
  var modal = weex.requireModule('modal')

  export default {
    components: { HomeView },
    data: {
    },
    ready: () => {
      modal.toast({
        message: '启动APP',
        duration: 3
      })
    },
    methods: {
    }
  }
</script>
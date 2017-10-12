<template>
  <div @androidback="back">
    <router-view style="flex:1"></router-view>
  </div>
</template>

<style>
</style>

<script>
  var modal = weex.requireModule('modal')

  export default {
    ready: () => {
      modal.toast({
        message: '启动APP',
        duration: 3
      })
    },
    methods: {
      back: function () {
        this.$router.back()
      }
    }
  }
</script>
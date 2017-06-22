<template>
  <div>
    <app-header title="首页"></app-header>
    <div>
    </div>
  </div>
</template>

<style>
</style>

<script>
  import AppHeader from './AppHeader.vue'
  var modal = weex.requireModule('modal')

  export default {
    components: { AppHeader },
    data: {
      title: 'Demo'
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
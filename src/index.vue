<template>
  <div>
    <app-header title="首页"></app-header>
    <div>
    </div>

    <wxc-tabbar :tab-items="tabItems"></wxc-tabbar>
  </div>
</template>

<style>
</style>

<script>
  import AppHeader from './AppHeader.vue'
  require('weex-components')

  var modal = weex.requireModule('modal')

  export default {
    components: { AppHeader },
    data: {
      tabItems: [
        {
          index: 0,
          title: "图片",
          titleColor: 0x0,
          icon: "",
          image: "http://gtms01.alicdn.com/tps/i1/TB1qw.hMpXXXXagXXXX9t7RGVXX-46-46.png",
          selectedImage: "http://gtms04.alicdn.com/tps/i4/TB16jjPMpXXXXazXVXX9t7RGVXX-46-46.png",
          src: "modules/main.js",
          visibility: "visible"
        },
        {
          index: 1,
          title: "阅读",
          titleColor: 0x0,
          icon: "",
          image: "http://gtms03.alicdn.com/tps/i3/TB1LEn9MpXXXXaUXpXX9t7RGVXX-46-46.png",
          selectedImage: "http://gtms02.alicdn.com/tps/i2/TB1qysbMpXXXXcnXXXX9t7RGVXX-46-46.png",
          src: "modules/read.js",
          visibility: "hidden"
        },
        {
          index: 2,
          title: "电影",
          titleColor: 0x0,
          icon: "",
          image: "http://gtms01.alicdn.com/tps/i1/TB1B0v5MpXXXXcvXpXX9t7RGVXX-46-46.png",
          selectedImage: "http://gtms04.alicdn.com/tps/i4/TB1NxY5MpXXXXcrXpXX9t7RGVXX-46-46.png",
          src: "modules/movie.js",
          visibility: "hidden"
        }
      ]
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
<template>
  <div class="header">
    <text class="title">{{title}}</text>
  </div>
</template>

<style scoped>
  .header {
    height: 20px;
  }

  .title {
    font-size: 18px;
    text-align: center;
  }
</style>

<script>
  export default {
    props: [
      'title'
    ]
  }
</script>
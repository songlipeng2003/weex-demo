<template>
  <div class="header">
    <text class="title">{{title}}</text>
  </div>
</template>

<style scoped>
  .header {
    height: 32px;
  }

  .title {
    font-size: 28px;
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
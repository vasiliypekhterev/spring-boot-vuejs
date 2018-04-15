<template>
  <header>
    <img src="./../assets/zero-small.png">
    <span class="title">Version Zero</span>
  </header>
</template>

<script>
export default {
  name: 'app-header'
}
</script>

<style lang="scss" scoped>
  header {
    box-sizing: border-box;
    background-color: #28BD28;
    display: flex;
    flex-direction: row;
    justify-content: flex-start;
    margin: 0;
    padding: 1rem;
    border-radius: 10px;
    .title {
      align-self: center;
      color: black;
      font-size: 1.6rem;
      font-weight: bold;
      margin-right: 1rem;
    }
  }
  img {
    width: 32px;
    border-radius: 50%;
    margin: 0 1rem;
  }
</style>

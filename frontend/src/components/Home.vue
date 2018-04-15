<template>
  <div class="home">
    <img src="./../assets/spring-boot-vuejs-logo.png">
    <a href="/#/board/" target="_blank">
      <h1>{{ msg }}</h1>
    </a>
  </div>
</template>

<script>
export default {
  name: 'home',
  data () {
    return {
      msg: 'Welcome to my first Vue.js powered Spring Boot App'
    }
  }
}
</script>

<style scoped>
h1, h2 {
  font-weight: normal;
}
a {
  text-decoration:none;
  color: #42b983;
}
a:hover {
  text-decoration:underline;
}
</style>

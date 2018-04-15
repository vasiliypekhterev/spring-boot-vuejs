<template>
  <div>
    <h1>User id: {{user.id}}</h1>
    <h2>User name: {{user.name}}</h2>
    <h2>User age: {{user.age}}</h2>
  </div>
</template>

<script>
import axios from 'axios'

export default {
  name: 'User',
  props: ['id'],
  data () {
    return {
      user: {}
    }
  },
  beforeRouteEnter (to, from, next) {
    axios.get('/api/get-user', {
        params: {
          id : to.params.id
        }
      })
      .then((response) => {
        next(vm => {
          vm.user = response.data
        })
      })
  }
}
</script>

<style scoped>
  h1, h2 {
    font-weight: normal;
  }
</style>

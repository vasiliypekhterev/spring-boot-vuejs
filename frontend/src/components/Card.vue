<template>
  <div>
        <div class="cardid">
          <span v-if="card.id != 0">
            {{card.type}}-{{card.id}}
          </span>
          <button v-if="card.id != 0" class="btn-delete" v-on:click="removeCard">
            Delete
          </button>
          <button class="btn-save" v-on:click="saveCard">
            Save
          </button>
        </div>
        <textarea class="cardtitle" :class="card.type" v-model="card.title"></textarea>

        <div class="cardbody">
          <div class="cardoptions">
            <label class="labels">Type: </label>
            <select v-model="card.type">
              <option v-for="type in types" :value="type">
                {{ type }}
              </option>
            </select>
          </div>
          <div class="cardoptions">
            <label class="labels">Status: </label>
            <select v-model="card.status">
              <option v-for="status in statuses" :value="status">
                {{ status }}
              </option>
            </select>
          </div>
          <div class="cardoptions">
            <label class="labels">Estimation: </label>
            <input v-model="card.estimation">
          </div>
          <div class="cardoptions">
            <label class="labels">Users: </label>
            <span v-for="user in card.users" :key="user.id">
              {{ user.name }}
            </span>
          </div>
          <div class="cardoptions">
            <select v-model="currentUser">
              <option v-for="user in users" :value="user">
                {{ user.name }}
              </option>
            </select>
            <button  v-on:click="addUser">
                Add User
            </button>
            <button  v-on:click="removeUser">
                Remove User
            </button>
          </div>
        </div>

        <label class="labels">Description</label>
        <textarea class="carddescription" v-model="card.description"></textarea>
  </div>
</template>

<script>
import axios from 'axios'

export default {
  name: 'Card',
  props: ['id'],
  data () {
    return {
      card: {},
      types: [],
      statuses: [],
      users: [],
      currentUser: null
    }
  },
  beforeRouteEnter (to, from, next) {
    axios.get('/api/get-card', {
      params: {
        id : to.params.id
      }
    })
    .then((response) => {
      next(vm => {
        vm.card = response.data
      })
    })
  },
  created () {
    this.$http.get('/api/get-types')
    .then((response) => {
        this.types = response.data
    })
    this.$http.get('/api/get-statuses')
    .then((response) => {
        this.statuses = response.data
    })
    this.$http.get('/api/get-users')
    .then((response) => {
        this.users = response.data
    })
  },
  methods:{
    saveCard: function(event)
      {
        this.$http.post('api/update-card', this.card)
        .then(function (response) {
            this.$router.push('/board')
        })
      },
    removeCard: function(event)
        {
          this.$http.post('api/remove-card', this.card.id)
          .then(function (response) {
              this.$router.push('/board')
          })
        },
    addUser: function(){
      if (this.currentUser == null){
          alert('You can not add empty user. Select user before adding!');
          return
      }
      if (this.card.users == null){
          this.card.users = []
          this.card.users.push(this.currentUser)
          return
      }
      var i = this.card.users.map(x=>x.id).indexOf(this.currentUser.id)
      if(i == -1) {
        this.card.users.push(this.currentUser)
      } else {
        alert('There is exist such user on this card.')
      }
    },
    removeUser: function(){
      if (this.card.users == null){
          alert('There is no such user on this card.')
          return
      }
      var i = this.card.users.map(x=>x.id).indexOf(this.currentUser.id)
      if(i != -1) {
	       this.card.users.splice(i, 1)
      } else {
         alert('There is no such user on this card.')
      }
    }
  }
}
</script>

<style scoped>
  h1, h2 {
    font-weight: normal;
  }

  .labels{
      font-weight: bold;
  }

  .cardid {
    align-items: center;
    justify-content: space-between;
    color: white;
    background: #444444;
    text-align: left;
    height: 1cm;
    font-size: 0.4cm;
  }

  .btn-save, .btn-delete {
    border: 1px solid white;
    color: #444444;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    border-radius: 4px;
    float: right;
    font-size: 0.4cm;
    margin: 0.1cm;
  }

  .cardtitle, .carddescription{
    font-family: "Proxima Nova","Lucida Sans Unicode","Lucida Grande",sans-serif;
    font-size: 1.6rem;
    color: white;
    padding: 0.5em;
    line-height: 1em;
    height: 100%;
    width: 100%;
    box-sizing: border-box;
  }

  .carddescription{
      background: #A2C4C9;
      color: black;
  }

  .DEFECT {
      background : red;
  }

  .STORY{
      background: green;
  }

  .cardoptions {
    border: 1px solid gray;
  }
</style>

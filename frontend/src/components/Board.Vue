<template>
  <div class="board">
      <div class="boardheader">
          <span class="title">Storyboard</span>
          <button class="btn-createcard" v-on:click="createCard">CreateCard</button>
      </div>
      <kanban-board :stages="statuses" :blocks="blocks" @update-block="updateBlock">
        <div v-for="item in blocks" :slot="item.id" :key="item.id">
            <CardSmall :card="item"></CardSmall>
        </div>
      </kanban-board>
  </div>
</template>

<script>
import axios from 'axios'
import { debounce } from 'lodash'
import CardSmall from './CardSmall'

export default {
  name: 'home',
  components: {
    CardSmall
  },
  data () {
    return {
      statuses: [''],
      blocks: []
    }
  },
  beforeRouteEnter (to, from, next) {
    axios.get('/api/get-statuses')
      .then((response) => {
        next(vm => {
          vm.statuses = response.data
        })
      })
  },
  beforeCreate () {
    this.$http.get(`api/get-cards`)
      .then(function (response) {
        this.blocks = response.data;
      })
  },
  methods: {
    updateBlock: debounce(function (id, status) {
      this.blocks.find(b => b.id === Number(id)).status = status
      var card = {  id: id,  status: status };
      this.$http.post('api/update-card-status', card)
      .then(function (response) {})
    }, 500),
    createCard: function(event){
      this.$router.push('/card/0')
    }
  }
}
</script>

<style lang="scss">
@import './../assets/board.scss';

* {
  box-sizing: border-box;
}
body {
  font-family: 'Lato';
  font-weight: 300;
  line-height: 1.5;
  -webkit-font-smoothing: antialiased;
}

.board {
  margin: 2px;
}

.boardheader {
  border : 1px solid rgba(black, 0.4);
  background : rgba(black, 0.2);
  margin: 1px;
  height: 1cm;
  text-align: left;
   .title{
      color: black;
      font-size: 0.6cm;
      margin: 0.1cm;
    }
    .btn-createcard{
      background-color: blue;
      border: none;
      color: white;
      text-align: center;
      text-decoration: none;
      display: inline-block;
      border-radius: 4px;
      float: right;
      font-size: 0.6cm;
      margin: 0.1cm;
    }
}

.board,
.boardheader {
  border-top-left-radius: 7px;
  border-top-right-radius: 7px;
}

.drag-column {
    &-NONE,
    &-BACKLOG {
      .drag-column-header,
      .drag-options {
          border-top: 7px solid #741B47;
      }
    }

    &-ACCEPTED {
      .drag-column-header,
      .drag-options {
          border-top: 7px solid green;
      }
    }
}
</style>

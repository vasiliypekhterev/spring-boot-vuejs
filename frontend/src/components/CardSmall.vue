<template>
<div class="cardsmall">
  <div class="cardid" :class="card.type">
    C-{{card.id}}
  </div>
  <div class="cardtitle">
    <router-link :to="{ name: 'Card', params: { id: card.id }}">
      {{card.title}}
    </router-link>
  </div>
  <div class="cardfooter">
    <div class="users">
      <div class="user" v-for="user in card.users" :key="user.id">
        <router-link :to="{ name: 'User', params: { id: user.id }}">
          {{user.name}}
        </router-link>
      </div>
    </div>
    <div class="estimation">
      {{card.estimation}}
    </div>
  </div>
</div>
</template>

<script>
export default {
  name: 'CardSmall',
  props: {
    card: {}
  }
}
</script>

<style scoped>

a {
  text-decoration:none;
}

a:hover {
  text-decoration:underline;
}

    .cardsmall{
      position: relative;
    }

    .cardid {
        margin: 0 0 0 5px;
        width: 30%;
        height: 15px;
        color: white;
        font-size: 10px;
        border-bottom-left-radius: 500px;
        border-bottom-right-radius: 500px;
    }

    .cardtitle{
        text-align: left;
        margin: 0 0 0 5px;
        font-size: 14px;
    }

    .DEFECT {
        background : red;
    }

    .STORY{
        background: green;
    }

    .cardfooter{
      display: table;
      width: 100%;
      padding: 5px 0;
      font-size: 0.75em;
    }

    .users{
      height: 60%;
      display: table-cell;
    }

    .estimation{
      height: 40%;
      display: table-cell;
      float: right;
      margin-right: 5px;
    }

    .user{
      display: inline-block;
      float: left;
    }

</style>

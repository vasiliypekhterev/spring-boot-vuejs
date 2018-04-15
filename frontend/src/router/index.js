import Vue from 'vue'
import Router from 'vue-router'
import Home from '@/components/Home'
import Board from '@/components/Board'
import Card from '@/components/Card'
import User from '@/components/User'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'Home',
      component: Home
    },
    {
      path: '/board',
      name: 'Board',
      component: Board
    },
    {
      path: '/card/:id',
      name: 'Card',
      component: Card,
      props: true
    },
    {
      path: '/user/:id',
      name: 'User',
      component: User,
      props: true
    }
  ]
})

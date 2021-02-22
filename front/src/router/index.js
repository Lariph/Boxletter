import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'
import Adicionar from '../views/Adicionar.vue'
import Atualizar from '../views/Atualizar.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '/adicionar',
    name: 'Adicionar',
    component: Adicionar
  },
  {
    path: '/atualizar/:id',
    name: 'Atualizar',
    component: Atualizar
  }

]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router

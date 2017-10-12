import { LOGIN, LOGOUT } from '../mutation-types'

const localStorage = window.localStorage
const prefix = 'demo_'

// 该模块的初始状态
const state = {
  logined: localStorage.getItem(prefix + 'logined'),
  token: localStorage.getItem(prefix + 'token'),
  userId: localStorage.getItem(prefix + 'userId'),
  name: localStorage.getItem(prefix + 'name'),
  role: localStorage.getItem(prefix + 'role')
}

// 相关的 mutations
const mutations = {
  [LOGIN] (state, user) {
    state.logined = true
    state.token = user.token
    state.userId = user.id
    state.name = user.name
    state.role = user.job

    localStorage.setItem(prefix + 'logined', true)
    localStorage.setItem(prefix + 'token', user.token)
    localStorage.setItem(prefix + 'userId', user.id)
    localStorage.setItem(prefix + 'name', user.name)
    localStorage.setItem(prefix + 'role', user.job)
  },
  [LOGOUT] (state) {
    localStorage.removeItem(prefix + 'logined')
    localStorage.removeItem(prefix + 'token')
    localStorage.removeItem(prefix + 'userId')
    localStorage.removeItem(prefix + 'name')
    localStorage.removeItem(prefix + 'role')
    state.logined = null
    state.token = null
    state.userId = null
    state.name = null
    state.role = null
  }
}

export default {
  state,
  mutations
}

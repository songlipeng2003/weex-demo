import * as types from './mutation-types'

export const login = ({ commit }, user) => {
  commit(types.LOGIN, user)
}

export const logout = ({ commit }) => {
  commit(types.LOGOUT)
}

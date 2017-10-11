import http from './http'

import API_KEY from '../config'

export const Image = {
	query(params) {
		params.key = API_KEY

		return axios.get('', {
			params: params
		})
	}
}
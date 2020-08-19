import Axios from 'axios'

Axios.defaults.timeout = 5 * 1000
Axios.defaults.headers.post['Content-Type'] = 'application/json;charset=UTF-8'
Axios.defaults.baseURL = '/manager'
Axios.interceptors.request.use(
  (config) => {
    return config
  }, (error) => {
    return Promise.reject(error)
  }
)

Axios.interceptors.response.use((response) => {
  return response.data
}, (error) => {
  return Promise.resolve(error)
})

export default Axios

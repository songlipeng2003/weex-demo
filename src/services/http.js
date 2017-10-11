import axios from 'axios'

axios.defaults.timeout = 5000

配置请求头
axios.defaults.baseURL = 'https://pixabay.com/api/'   //配置接口地址

//POST传参序列化(添加请求拦截器)
axios.interceptors.request.use((config) => {
	//在发送请求之前做某件事
    if(config.method  === 'post'){
        config.data = qs.stringify(config.data)
    }
    return config;
},(error) =>{
    return Promise.reject(error);
});

//返回状态判断(添加响应拦截器)
axios.interceptors.response.use((res) =>{
    if(!res.data.success){
        return Promise.reject(res)
    }
    return res;
}, (error) => {
    return Promise.reject(error)
});

export axios
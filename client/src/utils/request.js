import Taro from '@tarojs/taro';

let baseUrl = '/api/';

if (process.env.SERVER_URL) {
  baseUrl = window.location.origin + "/api/";
}

function baseOptions (params, method = 'GET') {
  let { url, data } = params;
  let contentType = 'application/json';
  const option = {
    isShowLoading: false,
    loadingText: '正在加载',
    url: baseUrl + url,
    data,
    method: method,
    header: {
      'content-type': contentType,
      'authorization': localStorage.getItem('token'),
    },
  };
  return Taro.request(option).then((res) => {
    const { statusCode, data: errorData } = res;
    console.log(`路径：${url},状态码：${statusCode},数据：`, errorData);
    if (statusCode >= 200 && statusCode < 300) {
      return res.data;
    } else if (statusCode === 400) {
      throw new Error(`错误码：${errorData.code}，消息：${errorData.description}`);
    } else if (statusCode === 401) {
      throw new Error(`401`);
    } else {
      throw new Error(`网络请求错误，状态码${statusCode}`);
    }
  });
}

export default {
  get (url, data = '') {
    let option = { url, data };
    return baseOptions(option);
  },
  post: function (url, data) {
    let params = { url, data };
    return baseOptions(params, 'POST');
  },
};

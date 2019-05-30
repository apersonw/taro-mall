import Taro from '@tarojs/taro';
import Config from '../Config';

const URL_PATTERN = /{([^}]+?)}/g;

class RequestImpl {

  params;

  init({ serviceId, method, url, pathVars, formVars }) {
    //键值对转路径参数
    if (pathVars) {
      url = url.replace(URL_PATTERN, (key) => {
        return encodeURIComponent(pathVars[key]);
      });
    }
    this.params = { serviceId, method, url, formVars };
  };

  start() {
    console.log('发起请求');
    let { serviceId, method, url, formVars } = this.params;
    return new Promise((resolve, reject) => {

      method = method.toUpperCase();
      const data = this.isPostData ? reqData : null;

      Taro.request({
        url,
        method,
        data,
        header: {
          'Content-Type': 'application/x-www-form-urlencoded',
          'authorization': Config.token,
          'Accept-Language': 'zh-CN',
        },
        success: (res) => {
          resolve(res);
        },
        fail: (res) => {
          resolve(res);
        },
        complete: () => {
        },
      });
    });
  }
}

export default RequestImpl;

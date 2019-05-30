import Taro from '@tarojs/taro';
import Config from '../Config';

const URL_PATTERN = /{([^}]+?)}/g;

class RequestImpl {

  params;

  init({ serviceId, method, url, pathVars, formVars }) {
    //将路径参数存放到url上
    if (pathVars) {
      url = url.replace(URL_PATTERN, (_, key) => {
        return encodeURIComponent(pathVars[key]);
      });
    }
    this.params = { serviceId, method, url, formVars };
  };

  start() {
    console.log('发起请求');
    let { serviceId, method, url, formVars } = this.params;
    console.log(this.params);
    return new Promise((resolve, reject) => {

      method = method.toUpperCase();
      // const data = this.isPostData ? reqData : null;
      url = Config.urlPrefix + serviceId + '/' + url;
      Taro.request({
        url,
        method,
        data: {},
        dataType: 'text',
        responseType: 'text',
        mode: 'no-cors',
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

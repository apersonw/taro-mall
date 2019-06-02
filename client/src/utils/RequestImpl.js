import Taro from '@tarojs/taro';
import Config from '../Config';

const URL_PATTERN = /{([^}]+?)}/g;

function encodeDate(obj, prefix) {
  let str = [], p;
  if (isArray(obj)) {
    obj.forEach(function(v, p) {
      let k = prefix ? prefix + '[' + p + ']' : p;
      if (isObject(v) && (!(v instanceof Date))) {
        str.push(encodeDate(v, k));
      } else {
        str.push(encodeURIComponent(k) + '=' + encodeValue(v));
      }
    });
  } else {
    for (p in obj) {
      if (obj.hasOwnProperty(p)) {
        let k = prefix ? prefix + '.' + p : p, v = obj[p];
        if (undefined !== v) {
          if (isObject(v) && (!(v instanceof Date))) {
            str.push(encodeDate(v, k));
          } else {
            str.push(encodeURIComponent(k) + '=' + encodeValue(v));
          }
        }
      }
    }
  }
  return str.join('&');
}


function encodeValue(value) {
  if (value !== null && typeof (value) != 'undefined') {
    let str = value.toString();
    return encodeURIComponent(str);
  } else {
    return '';
  }
}

class RequestImpl {

  params;

  init({ serviceId, method, url, pathVars, formVars }) {
    //编码url
    if (pathVars) {
      url = url.replace(URL_PATTERN, (_, key) => {
        return encodeURIComponent(pathVars[key]);
      });
    }
    this.params = { serviceId, method, url, formVars };
  };

  start() {
    let { serviceId, method, url, formVars } = this.params;

    url = Config.urlPrefix + serviceId + '/' + url;
    console.log('formVars', formVars);
    const option = {
      url,
      data: formVars,
      method,
      header: {
        'Content-Type': 'application/x-www-form-urlencoded',
        'authorization': Config.token || Taro.getStorageSync('token'),
      },
    };
    return Taro
      .request(option)
      .then((res) => {
        const { statusCode, data: errorData } = res;
        if (statusCode >= 200 && statusCode < 300) {
          return res.data;
        } else if (statusCode === 401) {
          throw new Error('401');
        } else {
          console.log(errorData);
          throw new Error(errorData);
        }
      });
  }
}

export default RequestImpl;

import Taro from '@tarojs/taro';
import startsWith from 'lodash/startsWith';
import isEmpty from 'lodash/isEmpty';
import endsWith from 'lodash/endsWith';
import Config from '../Config';

const URL_PATTERN = /{([^}]+?)}/g;

function ofValue(data) {
  if (isEmpty(data)) {
    return null;
  } else if (startsWith(data, '{') && endsWith(data, '}')) {
    return JSON.parse(data);
  } else if (startsWith(data, '[') && endsWith(data, ']')) {
    return JSON.parse(data);
  } else {
    if ('true'.endsWith(data)) {
      return true;
    }
    if ('false'.endsWith(data)) {
      return true;
    }

    const isNumber = /^\d+$/.test(data);
    if (!isNumber) return data;
    try {
      let intv = parseInt(data);
      if (!isNaN(intv)) {
        return intv;
      }
    } catch (e) {
    }
    try {
      let number = parseFloat(data);
      if (!isNan(number)) {
        return number;
      }
    } catch (e) {
    }
    return data;
  }
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
    const token = Config.token;
    return new Promise((resolve, reject) => {
      Taro
        .request({
          url,
          data: formVars,
          method,
          dataType: 'text',
          responseType: 'text',
          header: {
            'Content-Type': 'application/x-www-form-urlencoded',
            'Authorization': Config.token || Taro.getStorageSync('token'),
          },
          success: (res) => {
            const { statusCode, data } = res;
            if (statusCode >= 200 && statusCode < 300) {
              const value = ofValue(data);
              resolve(value);
            } else {
              reject({ status: '401' });
            }
          },
        });
    });
  }
}

export default RequestImpl;

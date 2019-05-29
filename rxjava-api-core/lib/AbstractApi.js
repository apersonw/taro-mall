"use strict";

Object.defineProperty(exports, "__esModule", {
  value: true
});
exports.default = void 0;

var _HttpUtils = _interopRequireDefault(require("./HttpUtils"));

function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

class AbstractApi {
  /**
   * 发起http请求
   * @param serviceId 微服务Id，也可以设置为api请求前缀地址
   * @param method 请求方法：如GET
   * @param url 请求url
   * @param pathVars 路径参数
   * @param formVars form参数
   * @returns {Promise<any>} Promise返回值
   */
  _request(serviceId, method, url, pathVars, formVars) {
    return _HttpUtils.default.request(serviceId, tag, method, url, pathVars, formVars);
  }

}

var _default = AbstractApi;
exports.default = _default;
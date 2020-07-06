"use strict";

Object.defineProperty(exports, "__esModule", {
  value: true
});
exports.default = void 0;

var _HttpUtils = _interopRequireDefault(require("./HttpUtils"));

function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

function _classCallCheck(instance, Constructor) { if (!(instance instanceof Constructor)) { throw new TypeError("Cannot call a class as a function"); } }

function _defineProperties(target, props) { for (var i = 0; i < props.length; i++) { var descriptor = props[i]; descriptor.enumerable = descriptor.enumerable || false; descriptor.configurable = true; if ("value" in descriptor) descriptor.writable = true; Object.defineProperty(target, descriptor.key, descriptor); } }

function _createClass(Constructor, protoProps, staticProps) { if (protoProps) _defineProperties(Constructor.prototype, protoProps); if (staticProps) _defineProperties(Constructor, staticProps); return Constructor; }

var AbstractApi = /*#__PURE__*/function () {
  function AbstractApi() {
    _classCallCheck(this, AbstractApi);
  }

  _createClass(AbstractApi, [{
    key: "_request",

    /**
     * 发起http请求
     * @param serviceId 微服务Id，也可以设置为api请求前缀地址
     * @param method 请求方法：如GET
     * @param url 请求url
     * @param pathVars 路径参数
     * @param formVars form参数
     * @returns {Promise<any>} Promise返回值
     */
    value: function _request(serviceId, method, url, pathVars, formVars) {
      return _HttpUtils.default.request(serviceId, method, url, pathVars, formVars);
    }
  }]);

  return AbstractApi;
}();

var _default = AbstractApi;
exports.default = _default;
"use strict";

Object.defineProperty(exports, "__esModule", {
  value: true
});
exports.default = void 0;

class HttpUtils {
  static request(serviceId, method, url, pathVars, formVars) {
    let request = HttpUtils.factory();
    request.init({
      serviceId,
      method,
      url,
      pathVars,
      formVars
    });
    return request.start();
  }

  static setFactory(factory) {
    HttpUtils.factory = factory;
  }

}

var _default = HttpUtils;
exports.default = _default;
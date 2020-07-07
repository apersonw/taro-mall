"use strict";

Object.defineProperty(exports, "__esModule", {
  value: true
});
exports.default = void 0;

function _classCallCheck(instance, Constructor) { if (!(instance instanceof Constructor)) { throw new TypeError("Cannot call a class as a function"); } }

function _defineProperties(target, props) { for (var i = 0; i < props.length; i++) { var descriptor = props[i]; descriptor.enumerable = descriptor.enumerable || false; descriptor.configurable = true; if ("value" in descriptor) descriptor.writable = true; Object.defineProperty(target, descriptor.key, descriptor); } }

function _createClass(Constructor, protoProps, staticProps) { if (protoProps) _defineProperties(Constructor.prototype, protoProps); if (staticProps) _defineProperties(Constructor, staticProps); return Constructor; }

function _defineProperty(obj, key, value) { if (key in obj) { Object.defineProperty(obj, key, { value: value, enumerable: true, configurable: true, writable: true }); } else { obj[key] = value; } return obj; }

var HttpUtils = /*#__PURE__*/function () {
  function HttpUtils() {
    _classCallCheck(this, HttpUtils);
  }

  _createClass(HttpUtils, null, [{
    key: "request",
    value: function request(serviceId, method, url, pathVars, formVars) {
      var request = HttpUtils.factory();
      request.init({
        serviceId: serviceId,
        method: method,
        url: url,
        pathVars: pathVars,
        formVars: formVars
      });
      return request.start();
    }
  }, {
    key: "setFactory",
    value: function setFactory(factory) {
      HttpUtils.factory = factory;
    }
  }]);

  return HttpUtils;
}();

_defineProperty(HttpUtils, "factory", void 0);

var _default = HttpUtils;
exports.default = _default;
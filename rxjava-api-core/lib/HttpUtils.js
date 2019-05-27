"use strict";

Object.defineProperty(exports, "__esModule", {
    value: true
});

var _createClass = function () { function defineProperties(target, props) { for (var i = 0; i < props.length; i++) { var descriptor = props[i]; descriptor.enumerable = descriptor.enumerable || false; descriptor.configurable = true; if ("value" in descriptor) descriptor.writable = true; Object.defineProperty(target, descriptor.key, descriptor); } } return function (Constructor, protoProps, staticProps) { if (protoProps) defineProperties(Constructor.prototype, protoProps); if (staticProps) defineProperties(Constructor, staticProps); return Constructor; }; }();

function _classCallCheck(instance, Constructor) { if (!(instance instanceof Constructor)) { throw new TypeError("Cannot call a class as a function"); } }

var HttpUtils = function () {
    function HttpUtils() {
        _classCallCheck(this, HttpUtils);
    }

    _createClass(HttpUtils, null, [{
        key: "request",
        value: function request(serviceId, method, url, pathVars, formVars) {
            var request = HttpUtils.factory();
            request.init({ serviceId: serviceId, method: method, url: url, pathVars: pathVars, formVars: formVars });
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

exports.default = HttpUtils;
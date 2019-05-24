"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
var NAMES_PATTERN = /\{([^\}]+?)\}/g;
var SERVICE_PATTERN = /^rxjava-apis-person-(.+)/g;
var RequestImpl = /** @class */ (function () {
    function RequestImpl() {
    }
    RequestImpl.prototype.init = function (params) {
        var serviceId = params.serviceId, method = params.method, url = params.url, pathVars = params.pathVars, formVars = params.formVars;
        if (pathVars) {
            url = url.replace(NAMES_PATTERN, function (key) {
                return encodeURIComponent(pathVars[key]);
            });
        }
        this.params = { serviceId: serviceId, method: method, url: url, formVars: formVars };
    };
    RequestImpl.prototype.start = function () {
        return undefined;
    };
    return RequestImpl;
}());
exports.default = RequestImpl;

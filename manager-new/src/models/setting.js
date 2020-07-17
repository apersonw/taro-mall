"use strict";
var __assign = (this && this.__assign) || function () {
    __assign = Object.assign || function(t) {
        for (var s, i = 1, n = arguments.length; i < n; i++) {
            s = arguments[i];
            for (var p in s) if (Object.prototype.hasOwnProperty.call(s, p))
                t[p] = s[p];
        }
        return t;
    };
    return __assign.apply(this, arguments);
};
exports.__esModule = true;
var defaultSettings_1 = require("../../config/defaultSettings");
var updateColorWeak = function (colorWeak) {
    var root = document.getElementById('root');
    if (root) {
        root.className = colorWeak ? 'colorWeak' : '';
    }
};
var SettingModel = {
    namespace: 'settings',
    state: defaultSettings_1["default"],
    reducers: {
        changeSetting: function (state, _a) {
            if (state === void 0) { state = defaultSettings_1["default"]; }
            var payload = _a.payload;
            var colorWeak = payload.colorWeak, contentWidth = payload.contentWidth;
            if (state.contentWidth !== contentWidth && window.dispatchEvent) {
                window.dispatchEvent(new Event('resize'));
            }
            updateColorWeak(!!colorWeak);
            return __assign(__assign({}, state), payload);
        },
    },
};
exports["default"] = SettingModel;
//# sourceMappingURL=setting.js.map
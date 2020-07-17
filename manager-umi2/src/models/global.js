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
var __generator = (this && this.__generator) || function (thisArg, body) {
    var _ = { label: 0, sent: function() { if (t[0] & 1) throw t[1]; return t[1]; }, trys: [], ops: [] }, f, y, t, g;
    return g = { next: verb(0), "throw": verb(1), "return": verb(2) }, typeof Symbol === "function" && (g[Symbol.iterator] = function() { return this; }), g;
    function verb(n) { return function (v) { return step([n, v]); }; }
    function step(op) {
        if (f) throw new TypeError("Generator is already executing.");
        while (_) try {
            if (f = 1, y && (t = op[0] & 2 ? y["return"] : op[0] ? y["throw"] || ((t = y["return"]) && t.call(y), 0) : y.next) && !(t = t.call(y, op[1])).done) return t;
            if (y = 0, t) op = [op[0] & 2, t.value];
            switch (op[0]) {
                case 0: case 1: t = op; break;
                case 4: _.label++; return { value: op[1], done: false };
                case 5: _.label++; y = op[1]; op = [0]; continue;
                case 7: op = _.ops.pop(); _.trys.pop(); continue;
                default:
                    if (!(t = _.trys, t = t.length > 0 && t[t.length - 1]) && (op[0] === 6 || op[0] === 2)) { _ = 0; continue; }
                    if (op[0] === 3 && (!t || (op[1] > t[0] && op[1] < t[3]))) { _.label = op[1]; break; }
                    if (op[0] === 6 && _.label < t[1]) { _.label = t[1]; t = op; break; }
                    if (t && _.label < t[2]) { _.label = t[2]; _.ops.push(op); break; }
                    if (t[2]) _.ops.pop();
                    _.trys.pop(); continue;
            }
            op = body.call(thisArg, _);
        } catch (e) { op = [6, e]; y = 0; } finally { f = t = 0; }
        if (op[0] & 5) throw op[1]; return { value: op[0] ? op[1] : void 0, done: true };
    }
};
exports.__esModule = true;
var user_1 = require("@/services/user");
var GlobalModel = {
    namespace: 'global',
    state: {
        collapsed: false,
        notices: [],
    },
    effects: {
        fetchNotices: function (_, _a) {
            var data, unreadCount;
            var call = _a.call, put = _a.put, select = _a.select;
            return __generator(this, function (_b) {
                switch (_b.label) {
                    case 0: return [4 /*yield*/, call(user_1.queryNotices)];
                    case 1:
                        data = _b.sent();
                        return [4 /*yield*/, put({
                                type: 'saveNotices',
                                payload: data,
                            })];
                    case 2:
                        _b.sent();
                        return [4 /*yield*/, select(function (state) { return state.global.notices.filter(function (item) { return !item.read; }).length; })];
                    case 3:
                        unreadCount = _b.sent();
                        return [4 /*yield*/, put({
                                type: 'user/changeNotifyCount',
                                payload: {
                                    totalCount: data.length,
                                    unreadCount: unreadCount,
                                },
                            })];
                    case 4:
                        _b.sent();
                        return [2 /*return*/];
                }
            });
        },
        clearNotices: function (_a, _b) {
            var count, unreadCount;
            var payload = _a.payload;
            var put = _b.put, select = _b.select;
            return __generator(this, function (_c) {
                switch (_c.label) {
                    case 0: return [4 /*yield*/, put({
                            type: 'saveClearedNotices',
                            payload: payload,
                        })];
                    case 1:
                        _c.sent();
                        return [4 /*yield*/, select(function (state) { return state.global.notices.length; })];
                    case 2:
                        count = _c.sent();
                        return [4 /*yield*/, select(function (state) { return state.global.notices.filter(function (item) { return !item.read; }).length; })];
                    case 3:
                        unreadCount = _c.sent();
                        return [4 /*yield*/, put({
                                type: 'user/changeNotifyCount',
                                payload: {
                                    totalCount: count,
                                    unreadCount: unreadCount,
                                },
                            })];
                    case 4:
                        _c.sent();
                        return [2 /*return*/];
                }
            });
        },
        changeNoticeReadState: function (_a, _b) {
            var notices;
            var payload = _a.payload;
            var put = _b.put, select = _b.select;
            return __generator(this, function (_c) {
                switch (_c.label) {
                    case 0: return [4 /*yield*/, select(function (state) {
                            return state.global.notices.map(function (item) {
                                var notice = __assign({}, item);
                                if (notice.id === payload) {
                                    notice.read = true;
                                }
                                return notice;
                            });
                        })];
                    case 1:
                        notices = _c.sent();
                        return [4 /*yield*/, put({
                                type: 'saveNotices',
                                payload: notices,
                            })];
                    case 2:
                        _c.sent();
                        return [4 /*yield*/, put({
                                type: 'user/changeNotifyCount',
                                payload: {
                                    totalCount: notices.length,
                                    unreadCount: notices.filter(function (item) { return !item.read; }).length,
                                },
                            })];
                    case 3:
                        _c.sent();
                        return [2 /*return*/];
                }
            });
        },
    },
    reducers: {
        changeLayoutCollapsed: function (state, _a) {
            if (state === void 0) { state = { notices: [], collapsed: true }; }
            var payload = _a.payload;
            return __assign(__assign({}, state), { collapsed: payload });
        },
        saveNotices: function (state, _a) {
            var payload = _a.payload;
            return __assign(__assign({ collapsed: false }, state), { notices: payload });
        },
        saveClearedNotices: function (state, _a) {
            if (state === void 0) { state = { notices: [], collapsed: true }; }
            var payload = _a.payload;
            return __assign(__assign({ collapsed: false }, state), { notices: state.notices.filter(function (item) { return item.type !== payload; }) });
        },
    },
    subscriptions: {
        setup: function (_a) {
            var history = _a.history;
            // Subscribe history(url) change, trigger `load` action if pathname is `/`
            history.listen(function (_a) {
                var pathname = _a.pathname, search = _a.search;
                if (typeof window.ga !== 'undefined') {
                    window.ga('send', 'pageview', pathname + search);
                }
            });
        },
    },
};
exports["default"] = GlobalModel;
//# sourceMappingURL=global.js.map
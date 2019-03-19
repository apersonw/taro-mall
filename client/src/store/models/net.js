import Taro from '@tarojs/taro'
import action from '../../utils/action'

function toast(msg) {
  Taro.showToast({
    icon: "none",
    title: msg + "",
  });
}

export default {
  namespace: 'net',
  state: {},
  effects: {
    * error({payload: e}, {all, call, put}) {
      console.error("error:", e);
      if (e instanceof String) {
        toast(`${e}`);
      } else if (e instanceof Error) {
        toast(`${e.message || e}`);
      } else if (e && e.status) {
        if (e.status === 401) {
          toast("未登陆:");
        } else {
          if (e.data) {
            toast(e.data.message);
          } else if (e.value) {
            toast(e.value.message);
          } else {
            toast(e.errMsg || "网络请求错误:" + e.status);
          }
        }
      } else {
        toast(e.errMsg || "网络请求错误:" + e.status);
      }
    },
  },
  reducers: {
    save(state, {payload}) {
      return {...state, ...payload};
    },
  },
};

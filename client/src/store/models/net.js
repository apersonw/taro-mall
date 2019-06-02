import Taro from '@tarojs/taro';

function toast(msg) {
  Taro.showToast({
    icon: 'none',
    title: msg + '',
  });
}

export default {
  namespace: 'net',
  state: {},
  effects: {
    * error({ payload: e }, { all, call, put }) {
      if (e.message === '401') {
        yield call(Taro.redirectTo, { url: '/pages/token/login' });
      } else {
        toast(e.message || '网络请求错误:' + e.status);
      }
    },
  },
  reducers: {
    save(state, { payload }) {
      return { ...state, ...payload };
    },
  },
};

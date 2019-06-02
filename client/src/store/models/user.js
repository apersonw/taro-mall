import UserApi from 'rxjava-apis-user-client/UserApi';
import Taro from '@tarojs/taro';
import Config from '../../Config';

export default {
  namespace: 'user',
  state: {},
  effects: {
    * fetch({ payload }, { all, call, put }) {
      yield call(UserApi.getCurrentUser);
    },
    * loginByPhoneSms({ payload: { phone, sms } }, { all, call, put }) {
      const data = yield call(UserApi.loginByPhoneSms, { phone, sms });
      Config.token = data;
      Taro.setStorageSync('token', data);
    },
  },
  reducers: {
    save(state, { payload }) {
      return { ...state, ...payload };
    },
  },
};

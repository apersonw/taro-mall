import UserApi from 'rxjava-apis-user-client/UserApi';
import Taro from '@tarojs/taro';
import Config from '../../Config';

export default {
  namespace: 'user',
  state: {},
  effects: {
    * fetch(_, {call}) {
      yield call(UserApi.getCurrentUser);
    },
    * loginByPhoneSms({payload: {phone, sms}}, {call}) {
      const data = yield call(UserApi.loginByPhoneSms, {phone, sms});
      Config.token = data;
      Taro.setStorageSync('token', data);
      yield call(Taro.navigateTo, {url: '/pages/index/index'});
    },
  },
  reducers: {
    save(state, {payload}) {
      return {...state, ...payload};
    },
  },
};

// import TestApi from '../../TestApi';
import TestApi from 'rxjava-apis-example-client/TestApi';

export default {
  namespace: 'user',
  state: {},
  effects: {
    * fetch({ payload }, { all, call, put }) {
      console.log(TestApi.testPath);
      yield call(TestApi.testPath,"aasdfasdf");
    },
  },
  reducers: {
    save(state, { payload }) {
      return { ...state, ...payload };
    },
  },
};

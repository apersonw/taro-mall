import action from '../utils/action';

export default {
  namespace: 'pagination',

  state: {
    locations: {},
    links: {},
  },

  effects: {
    *fetchPages({ payload: params }, { call, put }) {
      const { queryCall, saveObj } = params;
      delete params.queryCall;
      delete params.saveObj;
      const { content } = yield call(queryCall, { ...params });
      yield put(action('pages/save', { content, saveObj }));
    },
  },

  reducers: {
    save(state, action) {
      return { ...state, ...action.payload };
    },
  },
};

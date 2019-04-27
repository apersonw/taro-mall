import action from '../utils/action';

export default {
  namespace: 'pagination',
  state: {},
  effects: {
    *fetchPages({ payload: params }, { call, put }) {
      const { queryCall, saveObj } = params;
      delete params.queryCall;
      delete params.saveObj;
      if (params && params.page && params.page > 0) {
        params.page -= 1;
      }
      const { content, number: currentPage, totalElements: total, size: pageSize } = yield call(
        queryCall,
        { ...params }
      );
      yield put(
        action('save', { saveObj, content: { currentPage: currentPage + 1, total, pageSize } })
      );
      yield put(action('pages/save', { content, saveObj }));
    },
  },

  reducers: {
    save(state, action) {
      return { ...state, [action.payload.saveObj]: action.payload.content };
    },
  },
};

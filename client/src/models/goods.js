import Taro from '@tarojs/taro';
import GoodsApi from 'rxjava-apis-goods-client/GoodsApi';
import action from '../utils/action';
import removeEmpty from '../utils/paramsUtils';

export default {
  namespace: 'goods',
  state: {
    params: {
      page: 0,
      pageSize: 10,
      hasMore: true,
    },
    goodsList: [],
  },
  effects: {
    * fetchList({ payload }, { call, put, select }) {
      try {
        console.log('fetchList', payload);
        //暂时不用，会出现滚动穿透的问题
        if (!payload.page) {
          payload.page = 0;
        }
        let { params, goodsList: oldGoodsList = [] } = yield select(({ goods }) => goods);
        if (!params.hasMore) {
          return;
        }

        let newParams;
        if (params.page === 0) {
          newParams = params;
          oldGoodsList = [];
        } else {
          newParams = { ...params, ...removeEmpty(payload) };
        }

        let goodsList = yield call(GoodsApi.getList, newParams.page, newParams.pageSize, { ...newParams });

        if (goodsList&&goodsList.length) {
          newParams.hasMore = true;
          newParams.page = newParams.page + 1;
        } else {
          newParams.hasMore = false;
        }
        const newGoodsList = [...oldGoodsList, ...(goodsList || [])];
        yield put(action('save', { goodsList: newGoodsList, params: newParams }));
      } catch (e) {
        throw new Error(e);
      } finally {
      }
    },
  },
  reducers: {
    save(state, { payload }) {
      return { ...state, ...payload };
    },
  },
};

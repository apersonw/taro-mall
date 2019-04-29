import action from './action';
import { queryLocations } from '@/services/link';
import { queryGoods } from '@/services/api';
import { queryCategory } from '@/services/api';
import { queryBrand } from '@/services/api';
import { queryUser } from '@/services/api';
import { queryOrder } from '@/services/api';

const apis = {
  linkLocation: { queryCall: queryLocations, saveObj: 'linkLocations' },
  goods: { queryCall: queryGoods, saveObj: 'goodsList' },
  category: { queryCall: queryCategory, saveObj: 'categories' },
  brand: { queryCall: queryBrand, saveObj: 'brands' },
  user: { queryCall: queryUser, saveObj: 'users' },
  order: { queryCall: queryOrder, saveObj: 'orders' },
};
const fetchPage = (api, params = {}) => {
  if (api && apis.hasOwnProperty([api])) {
    const { page = 0, pageSize = 10 } = params;
    const { dispatch } = window.g_app._store;
    const { queryCall, saveObj } = apis[api];
    dispatch(action('pagination/fetchPages', { page, pageSize, queryCall, saveObj }));
  }
};
export default fetchPage;

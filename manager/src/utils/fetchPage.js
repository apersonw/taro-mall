import action from './action';
import { queryLocations } from '@/services/link';
import { queryGoods } from '@/services/api';
import { queryCategory } from '@/services/api';
import { queryBrand } from '@/services/api';

const names = {
  linkLocation: { queryCall: queryLocations, saveObj: 'linkLocations' },
  goods: { queryCall: queryGoods, saveObj: 'goodsList' },
  category: { queryCall: queryCategory, saveObj: 'categories' },
  brand: { queryCall: queryBrand, saveObj: 'brands' },
};
const fetchPage = (name, params = {}) => {
  if (name && names.hasOwnProperty([name])) {
    const { page = 0, pageSize = 10 } = params;
    const { dispatch } = window.g_app._store;
    const { queryCall, saveObj } = names[name];
    dispatch(action('pagination/fetchPages', { page, pageSize, queryCall, saveObj }));
  }
};
export default fetchPage;

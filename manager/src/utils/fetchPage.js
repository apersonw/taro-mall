import action from './action';
import { queryLocations } from '../services/link';

const names = {
  linkLocation: { queryCall: queryLocations, saveObj: 'linkLocations' },
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

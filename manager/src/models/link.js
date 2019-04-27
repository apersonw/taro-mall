import { queryLocations } from '@/services/link';

export default {
  namespace: 'link',
  state: {},
  effects: {},
  reducers: {
    save(state, action) {
      return {
        ...state,
        list: action.payload,
      };
    },
  },
};

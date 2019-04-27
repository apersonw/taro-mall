import { queryLocations } from '@/services/link';

export default {
  namespace: 'link',

  state: {
    list: {
      locations: [],
      links: [],
    },
    pagination: {
      locations: {},
    },
  },

  effects: {
    *fetchLocations(_, { call, put }) {
      yield call(queryLocations);
    },
  },

  reducers: {
    save(state, action) {
      return {
        ...state,
        list: action.payload,
      };
    },
  },
};

/**
 * 爬虫模块
 */
import { queryProjects } from '../services/api';

export default {
  namespace: 'scrapyd',
  state: {},
  effects: {
    *projects({ payload }, { call, put }) {
      yield call(queryProjects);
    },
  },
  reducers: {},
};

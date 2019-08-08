/**
 * 爬虫模块
 */
import { queryProjects, querySpiders } from '../services/api';
import action from '../utils/action';

export default {
  namespace: 'scrapyd',
  state: {},
  effects: {
    //项目列表
    *projects({ payload }, { call, put }) {
      const { status, projects = [] } = yield call(queryProjects);
      if (status === 'ok') {
        yield put(action('saveProjects', projects));
      }
    },
    //爬虫列表
    *spiders({ payload }, { call, put }) {
      const { status, spiders = [] } = yield call(querySpiders, { project: 'article' });
      if (status === 'ok') {
        yield put(action('saveSpiders', spiders));
      }
    },
  },
  reducers: {
    saveProjects(state, action) {
      return {
        ...state,
        projects: action.payload,
      };
    },
    saveSpiders(state, action) {
      return {
        ...state,
        spiders: action.payload,
      };
    },
  },
};

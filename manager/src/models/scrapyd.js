/**
 * 爬虫模块
 */
import { queryJobs, queryProjects, querySpiders } from '../services/api';
import action from '../utils/action';

export default {
  namespace: 'scrapyd',
  state: {},
  effects: {
    //项目列表
    *projects({ payload }, { call, put }) {
      const { status, projects = [] } = yield call(queryProjects);
      if (status === 'ok') {
        yield put(action('save', { projects }));
      }
    },
    //爬虫列表
    *spiders({ payload }, { call, put }) {
      const { status, spiders = [] } = yield call(querySpiders, { project: 'article' });
      if (status === 'ok') {
        yield put(action('save', { spiders }));
      }
    },
    //爬虫列表
    *jobs({ payload }, { call, put }) {
      const { status, runing = [], finished = [], pending = [] } = yield call(queryJobs);
      if (status === 'ok') {
        yield put(action('save', { runing, finished, pending }));
      }
    },
  },
  reducers: {
    save(state, { payload }) {
      return { ...state, ...payload };
    },
  },
};

/**
 * 权限模块
 */

export default {
  namespace: 'permission',
  state: {},
  effects: {
    //管理列表
    *managers({ payload }, { call, put }) {},
    //角色列表
    *roles({ payload }, { call, put }) {},
    //权限列表
    *permissions({ payload }, { call, put }) {},
  },
  reducers: {
    save(state, { payload }) {
      return { ...state, ...payload };
    },
  },
};

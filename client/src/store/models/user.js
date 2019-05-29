import action from "../../utils/action";

export default {
  namespace: "user",
  state: {},
  effects: {
    * fetch({ payload }, { all, call, put }) {
      console.log("查询用户信息");
      // yield call(TestApi.testewwPath, 'hello');
    }
  },
  reducers: {
    save(state, { payload }) {
      return { ...state, ...payload };
    }
  }
};

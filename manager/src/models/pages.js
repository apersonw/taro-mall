export default {
  namespace: 'pages',
  state: {},
  reducers: {
    save(state, action) {
      return {
        ...state,
        [action.payload.saveObj]: action.payload.content,
      };
    },
  },
};

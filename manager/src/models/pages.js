export default {
  namespace: 'pages',

  state: {
    locations: [],
    links: [],
  },

  reducers: {
    save(state, action) {
      return {
        ...state,
        [action.payload.saveObj]: action.payload.content,
      };
    },
  },
};

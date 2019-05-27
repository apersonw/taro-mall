import HttpUtils from 'rxjava-api-core';

export default {
  init(){
    HttpUtils.setFactory(() => new RequestImpl());
  },
  setStore(store) {
    this.store = store;
  }
};

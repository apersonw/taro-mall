import { HttpUtils } from 'rxjava-api-core';
import RequestImpl from './utils/RequestImpl'

export default {
  init() {
    HttpUtils.setFactory(() => new RequestImpl());
  },
  setStore(store) {
    this.store = store;
  },
};

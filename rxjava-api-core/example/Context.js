import { HttpUtils } from 'rxjava-api-core';
import RequestImpl from './RequestImpl';

export default {
  init() {
    console.log('Context init');
    HttpUtils.setFactory(() => new RequestImpl());
  },
  setStore() {

  },
};
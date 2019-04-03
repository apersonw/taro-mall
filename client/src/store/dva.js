import { create } from 'dva-core';
import createLoading from 'dva-loading';

let app;
let store;
let dispatch;
let localGlobal = {};

function createApp(opt) {
  app = create(opt);
  app.use(createLoading({}));

  if (!global) {
    localGlobal = global || {};
  }

  if (!localGlobal.registered) {
    opt.models.forEach(model => app.model(model));

    localGlobal.registered = true;
    if (global) {
      global.registered = localGlobal.registered;
    }
  }

  app.start();
  store = app._store;
  app.getStore = () => store;

  dispatch = store.dispatch;
  app.dispatch = dispatch;
  return app;
}

export default {
  createApp,
  getDispatch() {
    return app.dispatch;
  },
};

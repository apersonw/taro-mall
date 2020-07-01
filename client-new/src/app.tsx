import React, {Component} from 'react'
import {Provider} from 'react-redux'
import dva from "./utils/dva"
import models from "./models";

import './app.scss'
import Context from "./Context";
import action from "./utils/action";

//初始化上下文
Context.init();

const app = dva.createApp({
  initialState: {},
  models: models,
  onError(e, dispatch) {
    dispatch(action("net/error", e));//错误处理均放于此model解决
  }
});

let store = app.getStore();
Context.setStore(store);

class App extends Component {
  componentDidMount() {
  }

  componentDidShow() {
  }

  componentDidHide() {
  }

  componentDidCatchError() {
  }

  // 在 App 类中的 render() 函数没有实际作用
  // 请勿修改此函数
  render() {
    return (
      <Provider store={store}>
        {this.props.children}
      </Provider>
    )
  }
}

export default App

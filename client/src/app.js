import Taro, { Component } from "@tarojs/taro";
import "@tarojs/async-await";
import { Provider } from "@tarojs/redux";
import dva from "./utils/dva";
import Index from "./pages/index";
import "./app.scss";
import models from "./models";
import action from "./utils/action";
import Context from './Context';

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

  config = {
    pages: [
      "pages/index/index",
      "pages/category/index",
      "pages/shopcart/index",
      "pages/account/index",
      "pages/login/index",
      "pages/goodsDetail/index",
      "pages/searchGoodsList/index",
    ],
    window: {
      backgroundTextStyle: "light",
      navigationBarBackgroundColor: "#fff",
      navigationBarTitleText: "WeChat",
      navigationBarTextStyle: "black"
    }
  };

  // 在 App 类中的 render() 函数没有实际作用
  // 请勿修改此函数
  render () {
    return (
        <Provider store={store}>
          <Index />
        </Provider>
    )
  }
}

Taro.render(<App />, document.getElementById("app"));

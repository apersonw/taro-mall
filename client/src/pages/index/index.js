import Taro, { Component } from "@tarojs/taro";
import { View, Button, Text } from "@tarojs/components";
import { connect } from "@tarojs/redux";
import "./index.scss";
import action from "../../utils/action";

@connect()
class Index extends Component {

  config = {
    navigationBarTitleText: "首页"
  };

  componentDidMount() {
    const { dispatch } = this.props;
    dispatch(action("user/fetch"));
  }

  render() {
    return (
      <View className='index' >
        首页
      </View >
    );
  }
}

export default Index;

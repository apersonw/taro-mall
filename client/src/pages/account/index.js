import Taro, { Component } from '@tarojs/taro';
import { View } from '@tarojs/components';
import { connect } from '@tarojs/redux';
import TabBar from '../../components/TabBar';

@connect(() => ({}))
class Index extends Component {

  config = {
    navigationBarTitleText: '我的',
  };

  render() {
    return (
      <View >
        <View >我的页面</View >
        <TabBar />
      </View >
    );
  }
}

export default Index;

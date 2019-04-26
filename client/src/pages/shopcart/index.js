import Taro, { Component } from '@tarojs/taro';
import { View } from '@tarojs/components';
import { connect } from '@tarojs/redux';
import h5PageWrapper from '../../wrapper/h5PageWrapper';
import TabBar from '../../components/TabBar';

@h5PageWrapper
@connect(() => ({}))
class Index extends Component {

  config = {
    navigationBarTitleText: '购物车',
  };

  render() {
    return (
      <View >
        <View>购物车页面</View>
        <TabBar />
      </View >
    );
  }
}

export default Index;

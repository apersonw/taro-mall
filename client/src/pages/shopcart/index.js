import Taro, { Component } from '@tarojs/taro';
import { ScrollView, View } from '@tarojs/components';
import { connect } from '@tarojs/redux';
import TabBar from '../../components/TabBar';
import styles from './index.module.scss';

@connect(() => ({}))
class Index extends Component {

  config = {
    navigationBarTitleText: '购物车',
  };

  render() {
    const scrollStyle = {
      height: '100vh',
    };
    const scrollTop = 0;
    const Threshold = 20;
    const vStyleA = {
      height: '200vh',
      'background-color': 'rgb(26, 173, 25)',
    };
    const vStyleB = {
      height: '100vh',
      'background-color': 'rgb(39, 130, 215)',
    };
    const vStyleC = {
      height: '100vh',
      'background-color': 'rgb(241, 241, 241)',
      color: '#333',
    };
    return (
      <View className={styles.container} >
        <ScrollView
          className='scrollview'
          scrollY
          scrollWithAnimation
          scrollTop={scrollTop}
          style={scrollStyle}
          lowerThreshold={Threshold}
          upperThreshold={Threshold}
          onScrolltoupper={this.onScrolltoupper}
          onScroll={this.onScroll}
        >
          <View style={vStyleA} >A</View >
          <View style={vStyleB} >B</View >
          <View style={vStyleC} >C</View >
        </ScrollView >
        <TabBar />
      </View >
    );
  }
}

export default Index;

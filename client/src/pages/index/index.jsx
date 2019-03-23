import Taro, { Component } from '@tarojs/taro';
import { View, Button, Text } from '@tarojs/components';
import { connect } from '@tarojs/redux';
import styles from './index.module.scss';
import action from '../../utils/action';
import pageWrapper from '../../wrapper/pageWrapper';

@pageWrapper
@connect()
class Index extends Component {

  config = {
    navigationBarTitleText: '首页',
  };

  componentDidMount() {
    const { dispatch } = this.props;
    dispatch(action('user/fetch'));
  }

  render() {
    return (
      <View className={styles.container} >
        <View className='fixedHeader' >导航栏</View >
        <View className='content' >
          首页首页首页首页首页首页首页首页首页首页首页首页首页首页首页首页首页首页首页首页首页首页首页首页首页首页首页首页首页首页首页首页首页首页首页首页首页首页首页首页首页首页首页首页首页首页首页首页首页首页首页首页首页首页首页首页首页首页首页首页首页首页首页首页首页首页首页首页首页首页首页首页首页首页首页首页首页首页首页首页首页首页首页首页首页首页首页首页首页首页首页首页首页首页首页首页首页首页首页首页首页首页首页首页首页首页首页首页首页首页首页首页首页首页首页首页首页首页首页首页首页首页首页首页首页首页首页首页首页首页首页首页首页首页首页首页首页首页首页首页首页首页首页首页首页首页首页首页首页首页首页首页首页首页首页首页首页首页首页首页首页首页首页首页首页首页首页首页首页首页首页首页首页首页首页首页首页首页首页首页首页首页首页首页首页首页首页首页首页首页首页首页首页首页首页首页首页首页首页首页首页首页首页首页首页首页首页首页首页首页首页首页首页首页首页首页首页首页首页首页首页首页首页首页首页首页首页首页首页首页首页首页
        </View >
        <View className='toolBar' >底部tabBar</View >
      </View >
    );
  }
}

export default Index;

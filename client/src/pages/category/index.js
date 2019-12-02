import Taro, { Component } from '@tarojs/taro';
import { View, ScrollView } from '@tarojs/components';
import { connect } from '@tarojs/redux';
import menuList from '@/mock/category/menu.json';
import styles from './index.module.scss';
import TabBar from '../../components/TabBar';

@connect(() => ({}))
class Index extends Component {

  config = {
    navigationBarTitleText: '分类',
  };

  render() {
    return (
      <View className={styles.container}>
        <ScrollView
          scrollY
          className={styles.firstCategory}
        >
          {menuList.map((menu, index) => <View key={index} className={styles.categoryBox} >{menu}</View >)}
        </ScrollView >
        <ScrollView
          scrollY
          className={styles.contentView}
        >
          <View >手机</View >
          <View >手机</View >
          <View >手机</View >
          <View >手机</View >
          <View >手机</View >
          <View >手机</View >
          <View >手机</View >
          <View >手机</View >
          <View >手机</View >
          <View >手机</View >
          <View >手机</View >
          <View >手机</View >
          <View >手机</View >
          <View >手机</View >
          <View >手机</View >
          <View >手机</View >
          <View >手机</View >
          <View >手机</View >
          <View >手机</View >
          <View >手机</View >
          <View >手机</View >
          <View >手机</View >
          <View >手机</View >
          <View >手机</View >
          <View >手机</View >
          <View >手机</View >
          <View >手机</View >
          <View >手机</View >
          <View >手机</View >
          <View >手机</View >
          <View >手机</View >
          <View >手机</View >
          <View >手机</View >
          <View >手机</View >
          <View >手机</View >
          <View >手机</View >
          <View >手机</View >
          <View >手机</View >
          <View >手机</View >
          <View >手机</View >
          <View >手机</View >
          <View >手机</View >
          <View >手机</View >
          <View >手机</View >
          <View >手机</View >
          <View >手机</View >
          <View >手机</View >
          <View >手机</View >
          <View >手机</View >
          <View >手机</View >
          <View >手机</View >
          <View >手机</View >
          <View >手机</View >
          <View >手机</View >
          <View >手机</View >
          <View >手机</View >
          <View >手机</View >
          <View >手机</View >
          <View >手机</View >
          <View >手机</View >
          <View >手机</View >
          <View >手机</View >
          <View >手机</View >
          <View >手机</View >
          <View >手机</View >
          <View >手机</View >
          <View >手机</View >
          <View >手机</View >
          <View >手机</View >
          <View >手机</View >
          <View >手机</View >
          <View >手机</View >
          <View >手机</View >
          <View >手机</View >
          <View >手机</View >
          <View >手机</View >
          <View >手机</View >
          <View >手机</View >
          <View >手机</View >
          <View >手机</View >
          <View >手机</View >
          <View >手机</View >
          <View >手机</View >
          <View >手机</View >
          <View >手机</View >
          <View >手机</View >
          <View >手机</View >
          <View >手机</View >
          <View >手机</View >
          <View >手机</View >
          <View >手机</View >
          <View >手机</View >
          <View >手机</View >
          <View >手机</View >
          <View >手机</View >
          <View >手机</View >
          <View >手机</View >
          <View >手机</View >
          <View >手机</View >
          <View >手机</View >
          <View >手机</View >
          <View >手机</View >
          <View >手机</View >
          <View >手机</View >
          <View >手机</View >
          <View >手机</View >
          <View >手机</View >
          <View >手机</View >
          <View >手机</View >
          <View >手机</View >
          <View >手机</View >
          <View >手机</View >
          <View >手机</View >
          <View >手机</View >
          <View >手机</View >
          <View >手机</View >
          <View >手机</View >
          <View >手机</View >
          <View >手机</View >
          <View >手机</View >
          <View >手机</View >
          <View >手机</View >
          <View >手机</View >
          <View >手机</View >
          <View >手机</View >
          <View >手机</View >
          <View >手机</View >
          <View >手机</View >
          <View >手机</View >
          <View >手机</View >
          <View >手机</View >
          <View >手机</View >
          <View >手机</View >
          <View >手机</View >
          <View >手机</View >
          <View >手机</View >
          <View >手机</View >
          <View >手机</View >
          <View >手机</View >
          <View >手机</View >
          <View >手机</View >
          <View >手机</View >
          <View >手机</View >
          <View >手机</View >
          <View >手机</View >
          <View >手机</View >
          <View >手机</View >
          <View >手机</View >
          <View >手机</View >
          <View >手机</View >
          <View >手机</View >
          <View >手机</View >
          <View >手机</View >
          <View >手机</View >
          <View >手机</View >
          <View >手机</View >
          <View >手机</View >
          <View >手机</View >
          <View >手机</View >
          <View >手机</View >
          <View >手机</View >
          <View >手机</View >
          <View >手机</View >
          <View >手机</View >
          <View >手机</View >
          <View >手机</View >
          <View >手机</View >
          <View >手机</View >
          <View >手机</View >
          <View >手机</View >
          <View >手机</View >
          <View >手机</View >
          <View >手机</View >
          <View >手机</View >
          <View >手机</View >
          <View >手机</View >
          <View >手机</View >
          <View >手机</View >
          <View >手机</View >
          <View >手机</View >
        </ScrollView >
        <TabBar />
      </View >
    );
  }
}

export default Index;

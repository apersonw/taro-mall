import Taro, { Component } from '@tarojs/taro';
import { View, ScrollView } from '@tarojs/components';
import { connect } from '@tarojs/redux';
import styles from './index.module.scss';
import TabBar from '../../components/TabBar';

@connect(() => ({}))
class Index extends Component {

  config = {
    navigationBarTitleText: '分类',
  };

  render() {
    return (
      <View className={styles.container} >
        <ScrollView scrollY className={styles.firstCategory} >
          <View className={styles.categoryBox} >热门推荐</View >
          <View className={styles.categoryBox} >手机数码</View >
          <View className={styles.categoryBox} >家用电器</View >
          <View className={styles.categoryBox} >电脑办公</View >
          <View className={styles.categoryBox} >计生情趣</View >
          <View className={styles.categoryBox} >美妆护肤</View >
          <View className={styles.categoryBox} >个护清洁</View >
          <View className={styles.categoryBox} >汽车生活</View >
          <View className={styles.categoryBox} >京东超市</View >
          <View className={styles.categoryBox} >男装</View >
          <View className={styles.categoryBox} >男鞋</View >
          <View className={styles.categoryBox} >女装</View >
          <View className={styles.categoryBox} >女鞋</View >
          <View className={styles.categoryBox} >男婴童装</View >
          <View className={styles.categoryBox} >图书音像</View >
        </ScrollView >
        <ScrollView >
          <View >手机</View >
        </ScrollView >
        <TabBar />
      </View >
    );
  }
}

export default Index;

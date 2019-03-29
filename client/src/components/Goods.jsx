import { Component } from '@tarojs/taro';
import CustomImage from './CustomImage';
import styles from './Goods.module.scss';
import goods1 from '../assets/index/spike/goods-1@2x.png';
import { View } from '@tarojs/components';

class Goods extends Component {
  render() {
    return (
      <View className={styles.goods} >
        <CustomImage width={140} src={goods1} />
        <View className={styles.firstRow} >
          <View className={styles.symble} >¥</View >
          <View className={styles.price} >69</View >
        </View >
        <View className={styles.secendRow} >
          <View className={styles.symble} >¥</View >
          <View className={styles.price} >199</View >
        </View >
      </View >
    );
  }
}

export default Goods;

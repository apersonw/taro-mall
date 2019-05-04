import Taro, { Component } from '@tarojs/taro';
import CustomImage from '../CustomImage';
import styles from './GoodsItem.module.scss';
import { View } from '@tarojs/components';

class GoodsItem extends Component {
  render() {
    const { item = {} } = this.props;
    const price = ((item.coverPrice || 0) / 100).toFixed(2);
    return (
      <View className={styles.goods} >
        <CustomImage className={styles.thumb} src={item.thumb && item.thumb.key} />
        <View className={styles.name} >{item.name}</View >
        <View className={styles.bottom} >
          <View className={styles.left} >
            <View className={styles.symbol}>¥</View>
            <View className={styles.price}>{price}</View >
            <View className={styles.purchase}>拼购</View >
          </View >
          <View className={styles.similar}>看相似</View >
        </View >
      </View >
    );
  }
}

export default GoodsItem;

import { Component } from '@tarojs/taro';
import CustomImage from './CustomImage';
import styles from './GoodsSpike.module.scss';
import { View } from '@tarojs/components';

class GoodsSpike extends Component {
  render() {
    const { data = {} } = this.props;
    const { thumb = {}, coverPrice = 0 } = data;
    const { url } = thumb;

    const showCoverPrice = coverPrice / 100;
    return (
      <View className={styles.goods} >
        <CustomImage width={140} src={url} />
        <View className={styles.firstRow} >
          <View className={styles.symble} >¥</View >
          <View className={styles.price} >{showCoverPrice}</View >
        </View >
        <View className={styles.secendRow} >
          <View className={styles.symble} >¥</View >
          <View className={styles.price} >{showCoverPrice * 2}</View >
        </View >
      </View >
    );
  }
}

export default GoodsSpike;

import Taro,{ Component } from '@tarojs/taro';
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
        <CustomImage width={140} height={140} src={url} />
        <View className={styles.firstRow} >
          <View className={styles.firstSymble} >¥</View >
          <View className={styles.firstPrice} >{showCoverPrice}</View >
        </View >
        <View className={styles.secendRow} >
          <View className={styles.secendSymble} >¥</View >
          <View className={styles.secendPrice} >{showCoverPrice * 2}</View >
        </View >
      </View >
    );
  }
}

export default GoodsSpike;

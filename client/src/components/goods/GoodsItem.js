import Taro, { Component } from '@tarojs/taro';
import CustomImage from '../CustomImage';
import styles from './GoodsItem.module.scss';
import { View } from '@tarojs/components';

class GoodsItem extends Component {
  render() {
    const { item = {} } = this.props;
    return (
      <View className={styles.goods} >
        <CustomImage className={styles.thumb} width={372} height={372} src={item.thumb && item.thumb.url} />
        <View className={styles.name}>{item.name}</View >
        <View className={styles.bottom} >
          <View className={styles.left}>
            <View >¥</View >
            <View >{item.coverPrice}</View >
            <View >拼购</View >
          </View >
          <View >看相似</View >
        </View >
      </View >
    );
  }
}

export default GoodsItem;

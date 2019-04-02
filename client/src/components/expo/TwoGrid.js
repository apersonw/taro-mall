import Taro,{ Component } from '@tarojs/taro';
import { View } from '@tarojs/components';
import styles from './TwoGrid.module.scss';

class TwoGrid extends Component {
  render() {
    const { item = {} } = this.props;
    const { thumb = {}, subThumb = {} } = item;
    const { url: thumbUrl = '' } = thumb;
    const { url: subThumbUrl = '' } = subThumb;

    return (
      <View className={styles.twoGrid} >
        <View className={styles.titleBox}>
          <View className={styles.title} >{item.title}</View >
          <View className={styles.subTitle} >{item.subTitle}</View >
        </View >
        <View className={styles.imgBox} >
        </View >
      </View >
    );
  }
}

export default TwoGrid;

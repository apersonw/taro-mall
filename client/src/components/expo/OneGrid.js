import Taro,{ Component } from '@tarojs/taro';
import { View } from '@tarojs/components';
import styles from './OneGrid.module.scss';

class OneGrid extends Component {
  render() {
    const { item = {} } = this.props;
    const { thumb = {} } = item;
    const { url: thumbUrl = '' } = thumb;

    return (
      <View className={styles.oneGrid} >
        <View className={styles.titleBox} >
          <View className={styles.title} >{item.title}</View >
          <View className={styles.subTitle} >{item.subTitle}</View >
        </View >
        <View className={styles.imgBox} >
        </View >
      </View >
    );
  }
}

export default OneGrid;

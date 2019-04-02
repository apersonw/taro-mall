import Taro, { Component } from '@tarojs/taro';
import { View } from '@tarojs/components';
import styles from './Category.module.scss';

class Category extends Component {
  render() {
    const { items = [] } = this.props;
    return (
      <View className={styles.categoryBox} >
        {items.map((item, index) => (
          <View className={styles.categoryItem} key={index} >
            <View className={styles.categoryItemText} >{item.text}</View >
          </View >
        ))}
      </View >
    );
  }
}

export default Category;

import Taro, { Component } from '@tarojs/taro';
import { View, Image } from '@tarojs/components';
import styles from './FixedHeader.module.scss';
import categoryIcon from '../assets/index/category.png';
import getCls from '../utils/cls';

class FixedHeader extends Component {

  render() {
    const { fixedScroll = false } = this.props;

    const rnStyles = styles;
    return (
      <View className={styles} >
        <Image className={getCls('iconImg', rnStyles)} src={categoryIcon} />
        {/*<View className={styles.searchBox} >*/}
        {/*  <CustomImage className={styles.iconImg} width={50} height={30} src={icon} />*/}
        {/*  <View className={styles.vLine} />*/}
        {/*  <CustomImage className={styles.searchIcon} width={40} height={30} src={searchIcon} />*/}
        {/*  <Input className={styles.searchInput} placeholder="潮流电子特惠" />*/}
        {/*</View >*/}
        {/*<View className={styles.loginBtn} >登陆</View >*/}
      </View >
    );
  }
}

export default FixedHeader;

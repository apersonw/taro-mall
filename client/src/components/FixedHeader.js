import Taro, { Component } from '@tarojs/taro';
import { Input, View } from '@tarojs/components';
import styles from './FixedHeader.module.scss';
import CustomImage from './CustomImage';
import categoryIcon from '../assets/index/category@2x.png';
import icon from '../assets/index/icon.png';
import searchIcon from '../assets/index/searchIcon.png';

class FixedHeader extends Component {
  render() {
    const {fixedScroll = false} = this.props;
    return (
      <View className={[styles.fixedHeader, fixedScroll ? styles.fixedScrollHeader : '']} onTouchMove={event => {
        event.preventDefault();
        event.stopPropagation();
      }} >
        <CustomImage width={40} height={32} src={categoryIcon} />
        <View className={styles.searchBox} >
          <CustomImage className={styles.iconImg} width={50} height={30} src={icon} />
          <View className={styles.vLine} />
          <CustomImage className={styles.searchIcon} width={40} height={30} src={searchIcon} />
          <Input className={styles.searchInput} placeholder='潮流电子特惠' />
        </View >
        <View className={styles.loginBtn} onClick={() => Taro.navigateTo({url: '/pages/token/login'})} >登陆</View >
      </View >
    );
  }
}

export default FixedHeader;

import Taro from '@tarojs/taro';
import React from 'react';
import {Input, View} from '@tarojs/components';
import categoryIcon from '@/assets/index/category@2x.png';
import icon from '@/assets/index/icon.png';
import searchIcon from '@/assets/index/searchIcon.png';
import CustomImage from './CustomImage';
import styles from './FixedHeader.module.scss';

export default function FixedHeader(props) {
  console.log(props)
  return (
    <View>
      <CustomImage width={40} height={32} src={categoryIcon} />
      <View className={styles.searchBox}>
        <CustomImage className={styles.iconImg} width={50} height={30} src={icon} />
        <View className={styles.vLine} />
        <CustomImage className={styles.searchIcon} width={40} height={30} src={searchIcon} />
        <Input className={styles.searchInput} placeholder='潮流电子特惠' />
      </View>
      <View className={styles.loginBtn} onClick={() => Taro.navigateTo({url: '/pages/token/login'})}>登陆</View>
    </View>
  );
}

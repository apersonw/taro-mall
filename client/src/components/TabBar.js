import Taro, { Component } from '@tarojs/taro';
import { View } from '@tarojs/components';
import CustomImage from './CustomImage';
import styles from './TabBar.module.scss';
import indexUnSelectImg from '../assets/tabbar/indexUn@2x.png';
import categoryUnSelectImg from '../assets/tabbar/categoryUn@2x.png';
import shopcartUnSelectImg from '../assets/tabbar/shopcartUn@2x.png';
import mineUnSelectImg from '../assets/tabbar/mineUn@2x.png';
import indexSelectImg from '../assets/tabbar/index@2x.png';
import categorySelectImg from '../assets/tabbar/category@2x.png';
import shopcartSelectImg from '../assets/tabbar/shopcart@2x.png';
import mineSelectImg from '../assets/tabbar/mine@2x.png';

class TabBar extends Component {

  render() {
    const { path } = this.$router;
    const indexImg = (path === '/pages/index/index' ? indexSelectImg : indexUnSelectImg);
    const categoryImg = (path === '/pages/category/index' ? categorySelectImg : categoryUnSelectImg);
    const shopcartImg = (path === '/pages/shopcart/index' ? shopcartSelectImg : shopcartUnSelectImg);
    const mineImg = (path === '/pages/mine/index' ? mineSelectImg : mineUnSelectImg);
    return (
      <View className={[styles.toolBar, styles.tabBar]} >
        <CustomImage onClick={Taro.redirectTo.bind(this, { url: '/pages/index/index' })} className={styles.tabBarImgBox} width={48} height={75} src={indexImg} />
        <CustomImage onClick={Taro.redirectTo.bind(this, { url: '/pages/category/index' })} className={styles.tabBarImgBox} width={48} height={75} src={categoryImg} />
        <CustomImage onClick={Taro.redirectTo.bind(this, { url: '/pages/shopcart/index' })} className={styles.tabBarImgBox} width={72} height={75} src={shopcartImg} />
        <CustomImage onClick={Taro.redirectTo.bind(this, { url: '/pages/mine/index' })} className={styles.tabBarImgBox} width={48} height={75} src={mineImg} />
      </View >
    );
  }
}

export default TabBar;

import { Component } from '@tarojs/taro';
import { Input, Swiper, SwiperItem, View } from '@tarojs/components';
import { connect } from '@tarojs/redux';
import styles from './index.module.scss';
import action from '../../utils/action';
import pageWrapper from '../../wrapper/pageWrapper';
import CustomImage from '../../components/CustomImage';
import categoryIcon from '../../assets/index/category@2x.png';
import icon from '../../assets/index/icon.png';
import searchIcon from '../../assets/index/searchIcon.png';
import banner1 from '../../assets/banner/1.jpg';
import banner2 from '../../assets/banner/2.jpg';
import banner3 from '../../assets/banner/3.jpg';
import banner4 from '../../assets/banner/4.jpg';
import banner5 from '../../assets/banner/5.jpg';
import banner6 from '../../assets/banner/6.jpg';
import banner7 from '../../assets/banner/7.jpg';

@pageWrapper
@connect()
class Index extends Component {

  config = {
    navigationBarTitleText: '首页',
  };

  componentDidMount() {
    const { dispatch } = this.props;
    dispatch(action('user/fetch'));
  }

  render() {
    const swiperImgs = [banner1, banner2, banner3, banner4, banner5, banner6, banner7];
    return (
      <View className={styles.container} >
        <View className={['fixedHeader', styles.fixedHeader]} >
          <CustomImage width={40} height={32} src={categoryIcon} />
          <View className={styles.searchBox} >
            <CustomImage className={styles.iconImg} width={50} height={30} src={icon} />
            <View className={styles.vLine} />
            <CustomImage className={styles.searchIcon} width={40} height={30} src={searchIcon} />
            <Input className={styles.searchInput} placeholder="潮流电子特惠" />
          </View >
          <View className={styles.loginBtn} >登陆</View >
        </View >
        <View className='content' >
          <Swiper
            className={styles.swiper}
            indicatorColor='#999'
            indicatorActiveColor='#333'
            interval={2000}
            circular
            indicatorDots
            // autoplay
          >
            {swiperImgs.map(img => (
              <SwiperItem style="width:100% !importment;" >
                <CustomImage height={366} src={img} />
              </SwiperItem >
            ))}
          </Swiper >
        </View >
        <View className='toolBar' >底部tabBar</View >
      </View >
    );
  }
}

export default Index;

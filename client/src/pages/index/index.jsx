import { Component } from '@tarojs/taro';
import { Input, Swiper, SwiperItem, Text, View } from '@tarojs/components';
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
import shopImg from '../../assets/index/category/shop@2x.png';
import worldImg from '../../assets/index/category/world@2x.png';
import clothesImg from '../../assets/index/category/clothes@2x.png';
import freshImg from '../../assets/index/category/fresh@2x.png';
import rechargeImg from '../../assets/index/category/recharge@2x.png';
import allImg from '../../assets/index/category/all@2x.png';
import moneyImg from '../../assets/index/category/money@2x.png';
import couponImg from '../../assets/index/category/coupon@2x.png';
import timeImg from '../../assets/index/category/time@2x.png';
import buyImg from '../../assets/index/category/buy@2x.png';
import packageImg from '../../assets/index/newuser/package@2x.png';
import channelImg from '../../assets/index/newuser/channel@2x.png';
import exclusiveImg from '../../assets/index/newuser/exclusive@2x.png';
import moreImg from '../../assets/index/spike/more@2x.png';
//tabbar
import indexSelectImg from '../../assets/tabbar/indexSelect@2x.png';
import categoryUnSelectImg from '../../assets/tabbar/categoryUnSelect@2x.png';
import shopcardUnSelectImg from '../../assets/tabbar/shopcardUnSelect@2x.png';
import mineUnSelectImg from '../../assets/tabbar/mineUnSelect@2x.png';

@pageWrapper
@connect()
class Index extends Component {

  state = {
    fixedHeaderStyle: styles.fixedHeader,
  };

  config = {
    navigationBarTitleText: '首页',
  };

  componentDidMount() {
    const { dispatch } = this.props;
    dispatch(action('user/fetch'));

    window.onscroll = () => {
      //为了保证兼容性，这里取两个值，哪个有值取哪一个
      //scrollTop就是触发滚轮事件时滚轮的高度
      const scrollTop = document.documentElement.scrollTop || document.body.scrollTop;
      if (scrollTop > 0) {
        this.setState({
          fixedHeaderStyle: styles.fixedScrollHeader,
        });
      } else {
        this.setState({
          fixedHeaderStyle: styles.fixedHeader,
        });
      }
    };
  }

  render() {
    const { fixedHeaderStyle } = this.state;

    //幻灯片
    const swiperImgs = [banner1, banner2, banner3, banner4, banner5, banner6, banner7];
    const swiper = <Swiper
      className={styles.swiper}
      indicatorColor='#999'
      indicatorActiveColor='#333'
      interval={2000}
      circular
      indicatorDots
      autoplay
    >
      {swiperImgs.map(img => (
        <SwiperItem style="width:100% !importment;" >
          <CustomImage height={366} src={img} />
        </SwiperItem >
      ))}
    </Swiper >;

    const categoryItems = [
      { text: '京东超市', img: shopImg },
      { text: '海囤全球', img: worldImg },
      { text: '京东服饰', img: clothesImg },
      { text: '京东生鲜', img: freshImg },
      { text: '京东到家', img: timeImg },
      { text: '充值缴费', img: rechargeImg },
      { text: '9.9元拼', img: buyImg },
      { text: '领劵', img: couponImg },
      { text: '赚钱', img: moneyImg },
      { text: '全部', img: allImg },
    ];
    //分类
    const category = <View className={styles.categoryBox} >
      {categoryItems.map(item => (
        <View className={styles.categoryItem} >
          <CustomImage width={80} height={80} src={item.img} />
          <View className={styles.categoryItemText} >{item.text}</View >
        </View >
      ))}
    </View >;

    const newUserOwn = <View className={styles.newUserOwnBox} >
      <CustomImage width={343} height={214} src={packageImg} />
      <CustomImage width={162} height={214} src={channelImg} />
      <CustomImage width={162} height={214} src={exclusiveImg} />
    </View >;

    const spike = <View className={styles.spikeBox} >
      <View className={styles.spikeFirstRow} >
        <View className={styles.spikeRowLeft} >
          <View className={styles.spikeJd} >京东秒杀</View >
          <View className={styles.spikeClock} >22点场</View >
          <View className={styles.spikeCountDown} >
            <View className={styles.spikeCountDownText} >01</View >
            <View >:</View >
            <View className={styles.spikeCountDownText} >11</View >
            <View >:</View >
            <View className={styles.spikeCountDownText} >03</View >
          </View >
        </View >
        <View className={styles.spikeSecendRow} >
          <View className={styles.spikeRowLeft} >更多秒杀</View >
          <CustomImage width={22} height={22} src={moreImg} />
        </View >
      </View >
      <View >商品列</View >
    </View >;
    return (
      <View className={styles.container} >
        <View className={['fixedHeader', fixedHeaderStyle]} >
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
          {swiper}
          {category}
          {newUserOwn}
          {spike}
          <View >测试潮流电子测试潮流电子测试潮流电子测试潮流电子测试潮流电子测试潮流电子测试潮流电子测试潮流电子测试潮流电子测试潮流电子测试潮流电子测试潮流电子测试潮流电子测试潮流电子测试潮流电子测试潮流电子测试潮流电子测试潮流电子测试潮流电子测试潮流电子测试潮流电子测试潮流电子测试潮流电子测试潮流电子测试潮流电子测试潮流电子测试潮流电子测试潮流电子测试潮流电子测试潮流电子测试潮流电子测试潮流电子测试潮流电子测试潮流电子测试潮流电子测试潮流电子测试潮流电子测试潮流电子测试潮流电子测试潮流电子测试潮流电子测试潮流电子测试潮流电子测试潮流电子测试潮流电子测试潮流电子测试潮流电子测试潮流电子测试潮流电子测试潮流电子测试潮流电子测试潮流电子测试潮流电子测试潮流电子测试潮流电子测试潮流电子测试潮流电子测试潮流电子测试潮流电子测试潮流电子测试潮流电子测试潮流电子测试潮流电子测试潮流电子测试潮流电子测试潮流电子测试潮流电子测试潮流电子测试潮流电子测试潮流电子测试潮流电子测试潮流电子测试潮流电子测试潮流电子测试潮流电子测试潮流电子测试潮流电子测试潮流电子测试潮流电子测试潮流电子测试潮流电子测试潮流电子测试潮流电子测试潮流电子测试潮流电子测试潮流电子测试潮流电子测试潮流电子测试潮流电子测试潮流电子测试潮流电子测试潮流电子测试潮流电子测试潮流电子测试潮流电子测试潮流电子测试潮流电子测试潮流电子测试潮流电子测试潮流电子测试潮流电子测试潮流电子测试潮流电子测试潮流电子测试潮流电子测试潮流电子测试潮流电子测试潮流电子测试潮流电子测试潮流电子测试潮流电子测试潮流电子测试潮流电子测试潮流电子测试潮流电子测试潮流电子测试潮流电子测试潮流电子测试潮流电子测试潮流电子测试潮流电子测试潮流电子测试潮流电子测试潮流电子测试潮流电子测试潮流电子测试潮流电子测试潮流电子测试潮流电子测试潮流电子测试潮流电子测试潮流电子测试潮流电子测试潮流电子测试潮流电子测试潮流电子测试潮流电子测试潮流电子测试潮流电子测试潮流电子</View >
        </View >
        <View className={['toolBar', styles.tabBar]} >
          <CustomImage className={styles.tabBarImgBox} width={48} height={75} src={indexSelectImg} />
          <CustomImage className={styles.tabBarImgBox} width={48} height={75} src={categoryUnSelectImg} />
          <CustomImage className={styles.tabBarImgBox} width={72} height={75} src={shopcardUnSelectImg} />
          <Text className="iconfont" >&#xe608;</Text >
          <CustomImage className={styles.tabBarImgBox} width={48} height={75} src={mineUnSelectImg} />
        </View >
      </View >
    );
  }
}

export default Index;

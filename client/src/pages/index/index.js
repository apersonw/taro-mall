import Taro, { Component } from '@tarojs/taro';
import { Input, Swiper, SwiperItem, Text, View } from '@tarojs/components';
import { connect } from '@tarojs/redux';
import styles from './index.module.scss';
import action from '../../utils/action';
import CustomImage from '../../components/CustomImage';
import categoryIcon from '../../assets/index/category.png';
import icon from '../../assets/index/icon.png';
import searchIcon from '../../assets/index/searchIcon.png';
import banner1 from '../../assets/banner/1.jpg';
import banner2 from '../../assets/banner/2.jpg';
import banner3 from '../../assets/banner/3.jpg';
import banner4 from '../../assets/banner/4.jpg';
import banner5 from '../../assets/banner/5.jpg';
import banner6 from '../../assets/banner/6.jpg';
import banner7 from '../../assets/banner/7.jpg';
import shopImg from '../../assets/index/category/shop.png';
import worldImg from '../../assets/index/category/world.png';
import clothesImg from '../../assets/index/category/clothes.png';
import freshImg from '../../assets/index/category/fresh.png';
import rechargeImg from '../../assets/index/category/recharge.png';
import allImg from '../../assets/index/category/all.png';
import moneyImg from '../../assets/index/category/money.png';
import couponImg from '../../assets/index/category/coupon.png';
import timeImg from '../../assets/index/category/time.png';
import buyImg from '../../assets/index/category/buy.png';
import packageImg from '../../assets/index/newuser/package.png';
import channelImg from '../../assets/index/newuser/channel.png';
import exclusiveImg from '../../assets/index/newuser/exclusive.png';
import moreImg from '../../assets/index/spike/more.png';
//tabbar
import indexSelectImg from '../../assets/tabbar/indexSelect.png';
import categoryUnSelectImg from '../../assets/tabbar/categoryUnSelect.png';
import shopcardUnSelectImg from '../../assets/tabbar/shopcardUnSelect.png';
import mineUnSelectImg from '../../assets/tabbar/mineUnSelect.png';

//data
import goodsList from './mock.json';
import courtyardList from './courtyard.json';
import everydayList from './everyday.json';
//components
import GoodsSpike from '../../components/GoodsSpike';
import BannerSwiper from '../../components/BannerSwiper';
import Category from '../../components/Category';
import FixedHeader from '../../components/FixedHeader';
import TwoGrid from '../../components/expo/TwoGrid';
import courtyardTitleImg from '../../assets/index/courtyard/title.png';
import everydayTitleImg from '../../assets/index/everyday/title.png';
import OneGrid from '../../components/expo/OneGrid';

@connect(() => ({}))
class Index extends Component {

  state = {
    fixedHeaderStyle: false,
  };

  config = {
    navigationBarTitleText: '首页',
  };

  componentDidMount() {
    const { dispatch } = this.props;
    dispatch(action('user/fetch'));

    //window仅在h5下可用，小程序使用的onPageScroll
    if (window) {
      window.onscroll = () => {
        //为了保证兼容性，这里取两个值，哪个有值取哪一个
        //scrollTop就是触发滚轮事件时滚轮的高度
        const scrollTop = document.documentElement.scrollTop || document.body.scrollTop;
        if (scrollTop > 0) {
          if (!this.state.fixedHeaderStyle) {
            this.setState({
              fixedHeaderStyle: true,
            });
          }
        } else {
          this.setState({
            fixedHeaderStyle: false,
          });
        }
      };
    }
  }

  onPageScroll({ scrollTop }) {
    if (scrollTop > 0) {
      if (!this.state.fixedHeaderStyle) {
        this.setState({
          fixedHeaderStyle: true,
        });
      }
    } else {
      this.setState({
        fixedHeaderStyle: false,
      });
    }
  }

  render() {
    const { fixedHeaderStyle } = this.state;

    //幻灯片
    const swiperImgs = [banner1, banner2, banner3, banner4, banner5, banner6, banner7];


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
      <View className={styles.spikeScroll} >
        <View className={styles.goodsList} >
          {(goodsList || []).map((goods, index) => (
            <GoodsSpike key={index} data={goods} />
          ))}
        </View >
      </View >
    </View >;

    return (
      <View className={styles.flexContainer} >
        <View className={styles.scrollArea} >
          <View className={styles.container} >
            <FixedHeader fixedScroll={fixedHeaderStyle} />
            <View className={styles.content} >
              <BannerSwiper imgs={swiperImgs} />
              <Category items={categoryItems} />
              {newUserOwn}
              {spike}
              <CustomImage height={90} src={courtyardTitleImg} />
              <View className={styles.courtyardBox} >
                <View className={styles.courtyardBoxRow} >
                  {(courtyardList || []).slice(0, 2).map((item, index) => (
                    <TwoGrid item={item} key={index} />
                  ))}
                </View >
                <View className={styles.courtyardBoxRow} >
                  {(courtyardList || []).slice(2, 6).map((item, index) => (
                    <OneGrid item={item} key={index} />
                  ))}
                </View >
              </View >
              {/*每日逛*/}
              <CustomImage height={90} src={everydayTitleImg} />
              <View className={styles.everydayBox} >
                <View className={styles.everydayBoxRow} >
                  {(everydayList || []).map((item, index) => (
                    <OneGrid item={item} key={index} />
                  ))}
                </View >
              </View >
            </View >
            <View className={[styles.toolBar, styles.tabBar]} >
              <CustomImage className={styles.tabBarImgBox} width={48} height={75} src={indexSelectImg} />
              <CustomImage className={styles.tabBarImgBox} width={48} height={75} src={categoryUnSelectImg} />
              <CustomImage className={styles.tabBarImgBox} width={72} height={75} src={shopcardUnSelectImg} />
              <CustomImage className={styles.tabBarImgBox} width={48} height={75} src={mineUnSelectImg} />
            </View >
          </View >
        </View >
      </View >
    );
  }
}

export default Index;

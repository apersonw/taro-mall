import Taro, { Component } from '@tarojs/taro';
import { ScrollView, View } from '@tarojs/components';
import { connect } from '@tarojs/redux';
import styles from './index.module.scss';
import action from '../../utils/action';
import h5PageWrapper from '../../wrapper/h5PageWrapper';
import CustomImage from '../../components/CustomImage';
import upImg from '../../assets/index/up.png';
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
//data
import spikeGoodsList from './mock.json';
import courtyardList from './courtyard.json';
import everydayList from './everyday.json';
//components
import GoodsSpike from '../../components/GoodsSpike';
import BannerSwiper from '../../components/BannerSwiper';
import Category from '../../components/Category';
import FixedHeader from '../../components/FixedHeader';
import TwoGrid from '../../components/expo/TwoGrid';
import courtyardTitleImg from '../../assets/index/courtyard/title@2x.png';
import everydayTitleImg from '../../assets/index/everyday/title@2x.png';
import OneGrid from '../../components/expo/OneGrid';
import GoodsItem from '../../components/goods/GoodsItem';
import { Tab } from '../../../../../../interest/interest-admin/src/components/Login';
import TabBar from '../../components/TabBar';

@h5PageWrapper
@connect(({ goods }) => ({
  goodsList: goods.goodsList,
  params: goods.params,
}))
class Index extends Component {

  state = {
    fixedHeaderStyle: false,
  };

  config = {
    navigationBarTitleText: '首页',
  };

  componentDidMount() {
    const { dispatch } = this.props;
    dispatch(action('goods/fetchList', { page: 0, pageSize: 10 }));
  }

  onLoadMore = () => {
    const { dispatch, params } = this.props;
    const { page = 0, hasMore } = params;
    if (hasMore) {
      dispatch(action('goods/fetchList', { page }));
    }
  };

  onScroll = ({ detail }) => {
    const { scrollTop } = detail;
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

  render() {
    const { goodsList = [] } = this.props;
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
          {(spikeGoodsList || []).map(goods => (
            <GoodsSpike key={goods.id} data={goods} />
          ))}
        </View >
      </View >
    </View >;

    return (
      <View className={styles.container} >
        <FixedHeader fixedScroll={fixedHeaderStyle} />
        <ScrollView
          style='height: 100vh;'
          onScrollToLower={this.onLoadMore}
          lowerThreshold={300}
          scrollY
          onScroll={this.onScroll}
        >
          <View className={styles.content} >
            <BannerSwiper id="indexBanner" imgs={swiperImgs} />
            <Category items={categoryItems} />
            {newUserOwn}
            {spike}
            {/*东家小院*/}
            <CustomImage height={90} src={courtyardTitleImg} />
            <View className={styles.courtyardBox} >
              <View className={styles.row} >
                {(courtyardList || []).slice(0, 2).map((item, index) => (
                  <TwoGrid item={item} key={index} />
                ))}
              </View >
              <View className={styles.row} >
                {(courtyardList || []).slice(2, 6).map((item, index) => (
                  <OneGrid item={item} key={index} />
                ))}
              </View >
            </View >
            {/*每日逛*/}
            <CustomImage height={90} src={everydayTitleImg} />
            <View className={styles.everydayBox} >
              <View className={styles.row} >
                {(everydayList || []).map((item, index) => (
                  <OneGrid item={item} key={index} />
                ))}
              </View >
            </View >
            {/*  推荐列表*/}
            <View className={styles.recommendTitle} >
              <View className={styles.recommendLineLeft} />
              <CustomImage width={26} height={26} src={upImg} />
              <View className={styles.rightText} >为您推荐</View >
              <View className={styles.recommendLineRight} />
            </View >
            <View className={styles.recommendGoodsList} >
              {(goodsList || []).map((item) => (<GoodsItem key={item.id} item={item} />))}
            </View >
          </View >
        </ScrollView >
        <TabBar />
      </View >
    );
  }
}

export default Index;

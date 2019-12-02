import Taro, { Component } from '@tarojs/taro';
import { ScrollView, View } from '@tarojs/components';
import { connect } from '@tarojs/redux';
import CustomImage from '@/components/CustomImage';
import upImg from '@/assets/index/up.png';
import swiperImgs from '@/mock/index/banner';
import categoryItems from '@/mock/index/category';
import packageImg from '@/assets/index/newuser/package@2x.png';
import channelImg from '@/assets/index/newuser/channel@2x.png';
import exclusiveImg from '@/assets/index/newuser/exclusive@2x.png';
import moreImg from '@/assets/index/spike/more@2x.png';
//data
import spikeGoodsList from '@/mock/index/mock.json';
import courtyardList from '@/mock/index/courtyard.json';
import everydayList from '@/mock/index/everyday.json';
//components
import GoodsSpike from '@/components/GoodsSpike';
import BannerSwiper from '@/components/BannerSwiper';
import Category from '@/components/Category';
import FixedHeader from '@/components/FixedHeader';
import TwoGrid from '@/components/expo/TwoGrid';
import courtyardTitleImg from '@/assets/index/courtyard/title@2x.png';
import everydayTitleImg from '@/assets/index/everyday/title@2x.png';
import OneGrid from '@/components/expo/OneGrid';
import GoodsItem from '@/components/goods/GoodsItem';
import TabBar from '@/components/TabBar';
import styles from './index.module.scss';

@connect(({ goods, }) => ({
  goodsList: goods.goodsList,
  params: goods.params,
}))
class Index extends Component {

  state = {
    fixedHeaderStyle: false,
  };

  componentDidMount() {
    // dispatch(action('user/fetch'));
    // dispatch(action('goods/fetchList', { page: 0, pageSize: 10 }));
  }

  config = {
    navigationBarTitleText: '首页',
  };

  onLoadMore = () => {
    const { params } = this.props;
    const { hasMore } = params;
    if (hasMore) {
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
          className={styles.scrollView}
          onScrollToLower={this.onLoadMore}
          lowerThreshold={300}
          scrollY
          onScroll={this.onScroll}
          scrollWithAnimation
        >
          <BannerSwiper imgs={swiperImgs} />
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
            {(goodsList || []).map((item,index) => (
              <View  key={index} className={styles.goodsItem} >
                <GoodsItem key={item.id} item={item} />
              </View >
            ))}
          </View >
        </ScrollView >
        <TabBar />
      </View >
    );
  }
}

export default Index;

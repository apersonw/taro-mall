import Taro, { Component } from '@tarojs/taro';
import { Swiper, SwiperItem } from '@tarojs/components';
import CustomImage from './CustomImage';
import styles from './BannerSwiper.module.scss';

/**
 * 首页Banner幻灯片
 */
class BannerSwiper extends Component {
  render() {
    const { imgs = [] } = this.props;
    return (
      <Swiper
        className={styles.swiper}
        indicatorColor='#999'
        indicatorActiveColor='#333'
        interval={2000}
        circular
        indicatorDots
        autoplay
      >
        {imgs.map((img, index) => (
          <SwiperItem style='width:100% !importment;' key={index} >
            <CustomImage height={366} src={img} />
          </SwiperItem >
        ))}
      </Swiper >
    );
  }
}

export default BannerSwiper;

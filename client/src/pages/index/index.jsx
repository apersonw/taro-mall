import Taro, { Component } from '@tarojs/taro';
import { View, Button, Text } from '@tarojs/components';
import { connect } from '@tarojs/redux';
import styles from './index.module.scss';
import action from '../../utils/action';
import pageWrapper from '../../wrapper/pageWrapper';
import CustomImage from '../../components/CustomImage';
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

  state = {
    translateX: 0,
  };

  config = {
    navigationBarTitleText: '首页',
  };

  componentDidMount() {
    const { dispatch } = this.props;
    dispatch(action('user/fetch'));

    this.timerID = setInterval(
      this.onTranslateX,
      2000,
    );
  }

  onTranslateX = () => {
    let { translateX } = this.state;
    this.setState({ translateX: translateX <= 500 ? translateX + 100 : 0 });
  };

  componentWillUnmount() {
    clearInterval(this.timerID);
  }

  render() {
    const { translateX } = this.state;
    return (
      <View className={styles.container} >
        <View className='fixedHeader' >导航栏</View >
        <View className='content' >
          <View className={styles.slideList} style={`transform: translateX(-${translateX}%);`} >
            <CustomImage className={styles.slideImg} style="left:0%;" src={banner1} />
            <CustomImage className={styles.slideImg} style="left:100%;" src={banner2} />
            <CustomImage className={styles.slideImg} style="left:200%;" src={banner3} />
            <CustomImage className={styles.slideImg} style="left:300%;" src={banner4} />
            <CustomImage className={styles.slideImg} style="left:400%;" src={banner5} />
            <CustomImage className={styles.slideImg} style="left:500%;" src={banner6} />
            <CustomImage className={styles.slideImg} style="left:600%;" src={banner7} />
          </View >
        </View >
        <View className='toolBar' >底部tabBar</View >
      </View >
    );
  }
}

export default Index;

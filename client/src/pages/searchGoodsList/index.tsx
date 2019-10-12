import Taro, {Component} from '@tarojs/taro'
import {View} from '@tarojs/components'
import {connect} from '@tarojs/redux';
import styles from './index.module.less'

interface IProps {
  dispatch(e: any): void,
}

/**
 * 页面：搜索商品列表
 */
@connect(({dispatch}) => ({
  dispatch
}))
export default class Index extends Component<IProps> {

  constructor(props) {
    super(props)
  }

  render() {
    return (
      <View className={styles.index}>
        搜索商品列表页面
      </View>
    )
  }
}

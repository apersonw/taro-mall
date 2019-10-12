import Taro, {Component} from '@tarojs/taro'
import {View, Button, Input} from '@tarojs/components'
import {connect} from '@tarojs/redux';
import styles from './index.module.less'

interface IProps {
  dispatch(e: any): void,
}

/**
 * 页面：注册
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
        注册页面
      </View>
    )
  }
}

import React from 'react'
import {Text, View} from '@tarojs/components'
import {useDispatch} from 'react-redux'

import './index.scss'
import action from "../../utils/action";

// #region 书写注意
//
// 目前 typescript 版本还无法在装饰器模式下将 Props 注入到 Taro.Component 中的 props 属性
// 需要显示声明 connect 的参数类型并通过 interface 的方式指定 Taro.Component 子类的 props
// 这样才能完成类型检查和 IDE 的自动提示
// 使用函数模式则无此限制
// ref: https://github.com/DefinitelyTyped/DefinitelyTyped/issues/20796
//
// #endregion

export default function (props) {
  console.log(props);
  const dispatch = useDispatch();
  console.log(dispatch)
  return (
    <View className='index'>
      <View><Text onClick={()=>dispatch(action('net/error',{message:'401'}))}>Hello, World</Text></View>
    </View>
  )
}

import React from 'react'
import {Text, View} from '@tarojs/components'
import {useDispatch} from 'react-redux'

import action from "../../utils/action";

export default function (props) {
  console.log(props);
  const dispatch = useDispatch();
  console.log(dispatch)
  return (
    <View className='index'>
      <View><Text onClick={()=>dispatch(action('net/error',{message:'401'}))}>Hello, Error</Text></View>
    </View>
  )
}

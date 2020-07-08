import React from 'react'
import { Text, View } from '@tarojs/components'
import action from '@/utils/action';
import FixedHeader from "@/components/FixedHeader";
import { useDispatch } from 'react-redux'
import './index.scss'

export default function (props) {
  console.log(props);
  const dispatch = useDispatch();
  console.log(dispatch)
  return (
    <View className='index'>
      <FixedHeader />
      <View><Text onClick={() => dispatch(action('net/error', {message: '401'}))}>Hello, World</Text></View>
    </View>
  )
}

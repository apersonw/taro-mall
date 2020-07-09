import React from 'react'
import { Text, View } from '@tarojs/components'
import action from '@/utils/action'
import FixedHeader from "@/components/FixedHeader"
import { useDispatch } from 'react-redux'
import styles from './index.module.scss'

export default function () {
  const dispatch = useDispatch();
  return (
    <View className={styles.index}>
      <FixedHeader />
      <View><Text onClick={() => dispatch(action('net/error', {message: '401'}))}>Hello, World</Text></View>
    </View>
  )
}

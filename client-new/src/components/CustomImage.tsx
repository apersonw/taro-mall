import {Image} from '@tarojs/components'
import React from "react"

export default function CustomImage(props) {
  const {src} = props
  return (
    <Image src={src} />
  )
}

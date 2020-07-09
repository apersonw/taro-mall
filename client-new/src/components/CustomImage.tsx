import React from "react"
import {Image} from '@tarojs/components'

export default function CustomImage(props) {
  const {src,className} = props
  return (
    <Image className={className} src={src} />
  )
}

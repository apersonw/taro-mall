import Taro, {Component} from '@tarojs/taro';
import {Image} from '@tarojs/components';

class CustomImage extends Component {
  render() {
    let {src, width = 0, height = 0, className, mode = 'scaleToFill', onClick} = this.props;
    width = width && Taro.pxTransform(width);
    height = height && Taro.pxTransform(height);
    return (
      <Image onClick={onClick} mode={mode} className={className} style={'display: block;width:' + (width || '100%') + ';height:' + (height || '100%') + ';line-height:' + height} src={src} />
    );
  }
}

export default CustomImage;

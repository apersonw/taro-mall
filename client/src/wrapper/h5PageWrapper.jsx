import { View } from '@tarojs/components';
import './h5PageWrapper.scss';

// h5页面装饰器
// eslint-disable-next-line taro/no-stateless-component
export default function h5PageWrapper(C) {
  return class Page extends C {
    render() {
      const childRender = super.render();
      return (
        <View className='flexContainer' >
          <View className='scrollArea' >
            {childRender}
          </View >
        </View >
      );
    }
  };
}

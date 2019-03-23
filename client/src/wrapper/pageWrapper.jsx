import { View } from '@tarojs/components';
import './pageWrapper.scss';

// eslint-disable-next-line taro/no-stateless-component
export default function pageWrapper(C) {
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

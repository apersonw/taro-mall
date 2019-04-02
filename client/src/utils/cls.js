import Taro from '@tarojs/taro';

const getCls = (className, styles) => {
  if (styles) {
    return styles[className];
  }
  return className;
};

export default getCls;

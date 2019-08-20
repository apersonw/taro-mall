'use strict';
const path = require('path');

module.exports = {
  context: path.resolve(__dirname, './'),
  resolve: {
    extensions: ['.js', '.vue', '.json','.ts'],
    alias: {
      '@/assets': path.resolve(__dirname, '..', 'src/assets'),
      '@/components': path.resolve(__dirname, '..', 'src/components'),
      '@/utils': path.resolve(__dirname, '..', 'src/utils'),
      '@/mock': path.resolve(__dirname, '..', 'mock'),
      '@/package': path.resolve(__dirname, '..', 'package.json'),
    },
  },
};

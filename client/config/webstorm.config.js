'use strict';
const path = require('path');

module.exports = {
  context: path.resolve(__dirname, './'),
  resolve: {
    extensions: ['.js', '.vue', '.json','.ts'],
    alias: {
      '@/assets': path.resolve(__dirname, '..', 'src/assets'),
      '@/components': path.resolve(__dirname, '..', 'src/components'),
      '@/containers': path.resolve(__dirname, '..', 'src/containers'),
      '@/utils': path.resolve(__dirname, '..', 'src/utils'),
      '@/package': path.resolve(__dirname, '..', 'package.json'),
      '@/project': path.resolve(__dirname, '..', 'project.config.json'),
    },
  },
};

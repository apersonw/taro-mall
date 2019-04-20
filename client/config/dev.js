module.exports = {
  env: {
    NODE_ENV: '"development"',
  },
  defineConstants: {},
  weapp: {},
  h5: {
    devServer: {
      host: '0.0.0.0',
      port: 10086,
      proxy: {
        '/api': {
          target: 'http://192.168.2.214:8080',
          pathRewrite: { '^/api': '/' },
          secure: false,
        },
      },
    },
  },
};

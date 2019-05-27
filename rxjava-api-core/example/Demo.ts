import {get} from 'https';
// import {get} from 'http';

class Demo {
  constructor() {
    get('https://qy-h5-dev.billbear.cn/', (res) => {
      console.log('状态码:', res.statusCode);
      console.log('请求头:', res.headers);

      res.on('data', (d) => {
        process.stdout.write(d);
      });

    }).on('error', (e) => {
      console.error(e);
    });
  }
}

let demo = new Demo();

export default Demo;
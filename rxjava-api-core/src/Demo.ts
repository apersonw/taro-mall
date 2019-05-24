import {get} from 'https';

class Demo {
  constructor() {
    console.log('hello');
    get('https://www.baidu.com/', (res) => {
      console.log('状态码:', res.statusCode);
      console.log('请求头:', res.headers);

      res.on('data', (d) => {
        process.stdout.write(d);
      });

    }).on('error', (e) => {
      console.error(e);
    });
    console.log('cli');
  }
}

let demo = new Demo();

export default Demo;
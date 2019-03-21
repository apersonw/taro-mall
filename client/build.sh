#!/usr/bin/env bash

yarn global add @tarojs/cli@1.2.0
yarn
yarn build:h5

cd ./docker/
./build.sh

docker build -t registry.cn-beijing.aliyuncs.com/rxjava/taro-jd-client:latest .

docker push registry.cn-beijing.aliyuncs.com/rxjava/taro-jd-client:latest

#!/usr/bin/env bash
yarn build:h5

docker build . -t registry.cn-shanghai.aliyuncs.com/taro-mall/client
docker push registry.cn-shanghai.aliyuncs.com/taro-mall/client

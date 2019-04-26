#!/usr/bin/env bash
yarn build
docker build . -t registry.cn-shanghai.aliyuncs.com/taro-mall/manager
docker push registry.cn-shanghai.aliyuncs.com/taro-mall/manager

#!/usr/bin/env bash

./build.sh

docker run --rm -p 81:80 registry.cn-beijing.aliyuncs.com/rxjava/taro-jd-client:latest

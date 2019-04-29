#!/usr/bin/env bash

cd center
mvn clean install -Prelease
cd ..

center_tag=registry.cn-shanghai.aliyuncs.com/taro-mall/center
docker build ./center/target/docker-bin/ -t ${center_tag}
docker push ${center_tag}
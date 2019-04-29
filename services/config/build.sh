#!/usr/bin/env bash

cd config
mvn clean install -Prelease
cd ..

config_tag=registry.cn-shanghai.aliyuncs.com/taro-mall/config
docker build ./config/target/docker-bin/ -t ${config_tag}
docker push ${config_tag}
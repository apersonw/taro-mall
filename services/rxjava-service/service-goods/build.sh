#!/usr/bin/env bash

cd rxjava-service/service-goods
mvn clean install -Prelease
cd ../..

service_goods_tag=registry.cn-shanghai.aliyuncs.com/taro-mall/service-goods
docker build ./rxjava-service/service-goods/target/docker-bin/ -t ${service_goods_tag}
docker push ${service_goods_tag}
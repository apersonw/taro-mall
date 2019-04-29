#!/usr/bin/env bash
cd rxjava-service/service-order
mvn clean install -Prelease
cd ../..

service_order_tag=registry.cn-shanghai.aliyuncs.com/taro-mall/service-order
docker build ./rxjava-service/service-goods/target/docker-bin/ -t ${service_order_tag}
docker push ${service_order_tag}
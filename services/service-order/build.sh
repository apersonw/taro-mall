#!/usr/bin/env bash
mvn clean install -Prelease

service_order_tag=registry.cn-shanghai.aliyuncs.com/taro-mall/service-order:latest

docker build ./target/docker-bin/ -t ${service_order_tag}

docker push ${service_order_tag}
#!/usr/bin/env bash
mvn clean install -Prelease
service_goods_tag=registry.cn-shanghai.aliyuncs.com/taro-mall/service-goods:latest

docker build ./target/docker-bin/ -t ${service_goods_tag}

docker push ${service_goods_tag}
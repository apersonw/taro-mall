#!/usr/bin/env bash
mvn clean install -Prelease

service_card_tag=registry.cn-shanghai.aliyuncs.com/taro-mall/service-card:latest

docker build ./target/docker-bin/ -t ${service_card_tag}

docker push ${service_card_tag}
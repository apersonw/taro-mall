#!/usr/bin/env bash

mvn clean install -Prelease

gateway_person_tag=registry.cn-shanghai.aliyuncs.com/taro-mall/gateway-person:latest

docker build ./target/docker-bin/ -t ${gateway_person_tag}

docker push ${gateway_person_tag}
#!/usr/bin/env bash
mvn clean install -Prelease

gateway_manager_tag=registry.cn-shanghai.aliyuncs.com/taro-mall/gateway-manager:latest

docker build ./target/docker-bin/ -t ${gateway_manager_tag}

docker push ${gateway_manager_tag}
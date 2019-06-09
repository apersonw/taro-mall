#!/usr/bin/env bash

mvn clean install -Prelease

gateway_client_tag=registry.cn-shanghai.aliyuncs.com/taro-mall/gateway-client:latest

docker build ./target/docker-bin/ -t ${gateway_client_tag}

docker push ${gateway_client_tag}
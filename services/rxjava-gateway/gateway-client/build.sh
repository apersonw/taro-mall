#!/usr/bin/env bash

cd rxjava-gateway/gateway-client
mvn clean install -Prelease
cd ../..

gateway_client_tag=registry.cn-shanghai.aliyuncs.com/taro-mall/gateway-client
docker build ./rxjava-gateway/gateway-client/target/docker-bin/ -t ${gateway_client_tag}
docker push ${gateway_client_tag}
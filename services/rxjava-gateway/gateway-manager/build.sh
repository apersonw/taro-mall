#!/usr/bin/env bash

cd rxjava-gateway/gateway-client
mvn clean install -Prelease
cd ../..

gateway_manager_tag=registry.cn-shanghai.aliyuncs.com/taro-mall/gateway-manager
docker build ./rxjava-gateway/gateway-manager/target/docker-bin/ -t ${gateway_manager_tag}
docker push ${gateway_manager_tag}
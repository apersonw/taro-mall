#!/usr/bin/env bash
mvn clean install -Prelease

gateway_admin_tag=registry.cn-shanghai.aliyuncs.com/taro-mall/gateway-admin:latest

docker build ./target/docker-bin/ -t ${gateway_admin_tag}

docker push ${gateway_admin_tag}
#!/usr/bin/env bash
cd rxjava-service/service-manager
mvn clean install -Prelease
cd ../..

service_manager_tag=registry.cn-shanghai.aliyuncs.com/taro-mall/service-manager
docker build ./rxjava-service/service-goods/target/docker-bin/ -t ${service_manager_tag}
docker push ${service_manager_tag}
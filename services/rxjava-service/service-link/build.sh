#!/usr/bin/env bash
cd rxjava-service/service-link
mvn clean install -Prelease
cd ../..

service_link_tag=registry.cn-shanghai.aliyuncs.com/taro-mall/service-link
docker build ./rxjava-service/service-link/target/docker-bin/ -t ${service_link_tag}
docker push ${service_link_tag}
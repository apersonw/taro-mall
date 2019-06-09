#!/usr/bin/env bash
mvn clean install -Prelease

service_manager_tag=registry.cn-shanghai.aliyuncs.com/taro-mall/service-manager:latest

docker build ./target/docker-bin/ -t ${service_manager_tag}

docker push ${service_manager_tag}
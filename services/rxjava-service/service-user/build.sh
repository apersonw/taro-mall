#!/usr/bin/env bash
cd rxjava-service/service-user
mvn clean install -Prelease
cd ../..

service_user_tag=registry.cn-shanghai.aliyuncs.com/taro-mall/service-user
docker build ./rxjava-service/service-user/target/docker-bin/ -t ${service_user_tag}
docker push ${service_user_tag}
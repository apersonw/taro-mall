#!/usr/bin/env bash
if test "$1" == "y"
then
cd rxjava-service/service-manager
fi

mvn clean install -Prelease

if test "$1" == "y"
then
cd ../..
fi

service_manager_tag=registry.cn-shanghai.aliyuncs.com/taro-mall/service-manager:latest

if test "$1" == "y";
then
    docker build ./rxjava-service/service-manager/target/docker-bin/ -t ${service_manager_tag}
else
    docker build ./target/docker-bin/ -t ${service_manager_tag}
fi

docker push ${service_manager_tag}
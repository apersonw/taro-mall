#!/usr/bin/env bash
if test "$1" == "y"
then
cd rxjava-service/service-link
fi

mvn clean install -Prelease

if test "$1" == "y"
then
cd ../..
fi

service_link_tag=registry.cn-shanghai.aliyuncs.com/taro-mall/service-link:latest

if test "$1" == "y";
then
    docker build ./rxjava-service/service-link/target/docker-bin/ -t ${service_link_tag}
else
    docker build ./target/docker-bin/ -t ${service_link_tag}
fi

docker push ${service_link_tag}
#!/usr/bin/env bash
if test "$1" == "y"
then
cd rxjava-service/service-user
fi

mvn clean install -Prelease

if test "$1" == "y"
then
cd ../..
fi

service_user_tag=registry.cn-shanghai.aliyuncs.com/taro-mall/service-user:latest

if test "$1" == "y";
then
    docker build ./rxjava-service/service-goods/target/docker-bin/ -t ${service_user_tag}
else
    docker build ./target/docker-bin/ -t ${service_user_tag}
fi

docker push ${service_user_tag}
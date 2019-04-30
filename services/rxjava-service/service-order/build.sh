#!/usr/bin/env bash
if test "$1" == "y"
then
cd rxjava-service/service-order
fi

mvn clean install -Prelease

if test "$1" == "y"
then
cd ../..
fi

service_order_tag=registry.cn-shanghai.aliyuncs.com/taro-mall/service-order:latest

if test "$1" == "y";
then
    docker build ./rxjava-service/service-goods/target/docker-bin/ -t ${service_order_tag}
else
    docker build ./target/docker-bin/ -t ${service_order_tag}
fi

docker push ${service_order_tag}
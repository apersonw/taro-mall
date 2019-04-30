#!/usr/bin/env bash
if test "$1" == "y"
then
cd rxjava-gateway/gateway-manager
fi

mvn clean install -Prelease

if test "$1" == "y"
then
cd ../..
fi

gateway_manager_tag=registry.cn-shanghai.aliyuncs.com/taro-mall/gateway-manager:latest

if test "$1" == "y";
then
    docker build ./rxjava-gateway/gateway-manager/target/docker-bin/ -t ${gateway_manager_tag}
else
    docker build ./target/docker-bin/ -t ${gateway_manager_tag}
fi

docker push ${gateway_manager_tag}
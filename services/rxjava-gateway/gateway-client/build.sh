#!/usr/bin/env bash
if test "$1" == "y"
then
cd rxjava-gateway/gateway-client
fi

mvn clean install -Prelease

if test "$1" == "y"
then
cd ../..
fi

gateway_client_tag=registry.cn-shanghai.aliyuncs.com/taro-mall/gateway-client:latest

if test "$1" == "y";
then
    docker build ./rxjava-gateway/gateway-client/target/docker-bin/ -t ${gateway_client_tag}
else
    docker build ./target/docker-bin/ -t ${gateway_client_tag}
fi

docker push ${gateway_client_tag}
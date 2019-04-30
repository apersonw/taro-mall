#!/usr/bin/env bash
if test "$1" == "y"
then
cd config
fi

mvn clean install -Prelease

if test "$1" == "y"
then
cd ..
fi

config_tag=registry.cn-shanghai.aliyuncs.com/taro-mall/config:latest

if test "$1" == "y";
then
    docker build ./config/target/docker-bin/ -t ${config_tag}
else
    docker build ./target/docker-bin/ -t ${config_tag}
fi

docker push ${config_tag}
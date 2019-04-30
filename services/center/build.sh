#!/usr/bin/env bash
if test "$1" == "y"
then
cd center
fi

mvn clean install -Prelease

if test "$1" == "y"
then
cd ..
fi

center_tag=registry.cn-shanghai.aliyuncs.com/taro-mall/center:latest

if test "$1" == "y";
then
    docker build ./center/target/docker-bin/ -t ${center_tag}
else
    docker build ./target/docker-bin/ -t ${center_tag}
fi

docker push ${center_tag}
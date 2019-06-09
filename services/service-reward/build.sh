#!/usr/bin/env bash
mvn clean install -Prelease

service_reward_tag=registry.cn-shanghai.aliyuncs.com/taro-mall/service-reward:latest

docker build ./target/docker-bin/ -t ${service_reward_tag}

docker push ${service_reward_tag}
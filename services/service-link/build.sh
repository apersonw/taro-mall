#!/usr/bin/env bash
mvn clean install -Prelease

service_link_tag=registry.cn-shanghai.aliyuncs.com/taro-mall/service-link:latest

docker build ./target/docker-bin/ -t ${service_link_tag}

docker push ${service_link_tag}
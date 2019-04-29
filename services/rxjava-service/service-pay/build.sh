#!/usr/bin/env bash
cd rxjava-service/service-pay
mvn clean install -Prelease
cd ../..

service_pay_tag=registry.cn-shanghai.aliyuncs.com/taro-mall/service-pay
docker build ./rxjava-service/service-goods/target/docker-bin/ -t ${service_pay_tag}
docker push ${service_pay_tag}
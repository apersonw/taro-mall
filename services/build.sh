#!/usr/bin/env bash
#此脚本为本地构建推送镜像仓库
mvn clean install -Prelease

gateway_client_tag=registry.cn-shanghai.aliyuncs.com/taro-mall/gateway-client
docker build ./rxjava-gateway/gateway-client/target/docker-bin/ -t ${gateway_client_tag}
docker push ${gateway_client_tag}

gateway_manager_tag=registry.cn-shanghai.aliyuncs.com/taro-mall/gateway-manager
docker build ./rxjava-gateway/gateway-manager/target/docker-bin/ -t ${gateway_manager_tag}
docker push ${gateway_manager_tag}

service_goods_tag=registry.cn-shanghai.aliyuncs.com/taro-mall/service-goods
docker build ./rxjava-service/service-goods/target/docker-bin/ -t ${service_goods_tag}
docker push ${service_goods_tag}

service_order_tag=registry.cn-shanghai.aliyuncs.com/taro-mall/service-order
docker build ./rxjava-service/service-goods/target/docker-bin/ -t ${service_order_tag}
docker push ${service_order_tag}

service_manager_tag=registry.cn-shanghai.aliyuncs.com/taro-mall/service-manager
docker build ./rxjava-service/service-goods/target/docker-bin/ -t ${service_manager_tag}
docker push ${service_manager_tag}

service_pay_tag=registry.cn-shanghai.aliyuncs.com/taro-mall/service-pay
docker build ./rxjava-service/service-goods/target/docker-bin/ -t ${service_pay_tag}
docker push ${service_pay_tag}

service_user_tag=registry.cn-shanghai.aliyuncs.com/taro-mall/service-user
docker build ./rxjava-service/service-user/target/docker-bin/ -t ${service_user_tag}
docker push ${service_user_tag}

center_tag=registry.cn-shanghai.aliyuncs.com/taro-mall/center
docker build ./center/target/docker-bin/ -t ${center_tag}
docker push ${center_tag}

config_tag=registry.cn-shanghai.aliyuncs.com/taro-mall/config
docker build ./config/target/docker-bin/ -t ${config_tag}
docker push ${config_tag}
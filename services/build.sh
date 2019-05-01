#!/usr/bin/env bash

./center/build.sh y
./config/build.sh y
#
##网关
./rxjava-gateway/gateway-client/build.sh y
./rxjava-gateway/gateway-manager/build.sh y
#
##微服务
./rxjava-service/service-goods/build.sh y
./rxjava-service/service-link/build.sh y
./rxjava-service/service-manager/build.sh y
./rxjava-service/service-order/build.sh y
./rxjava-service/service-user/build.sh y

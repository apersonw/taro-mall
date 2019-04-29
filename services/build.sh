#!/usr/bin/env bash

#./center/build.sh
#./config/build.sh

#网关
./rxjava-gateway/gateway-client/build.sh
./rxjava-gateway/gateway-manager/build.sh

#微服务
./rxjava-service/service-goods/build.sh
./rxjava-service/service-link/build.sh
./rxjava-service/service-manager/build.sh
./rxjava-service/service-order/build.sh
./rxjava-service/service-user/build.sh

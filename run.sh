#!/usr/bin/env bash

#构建client
cd client
yarn global add @tarojs/cli@1.2.0
yarn
yarn build:h5
cd ..

#构建manager
cd manager
yarn
yarn build
cd ..

#构建service-goods
cd services/service-goods
mvn clean package -Prelease
cd ../..

#构建service-user
cd services/service-user
mvn clean package -Prelease
cd ../..

pwd
##运行docker-compose
docker-compose up --build
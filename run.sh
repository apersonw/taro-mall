#!/usr/bin/env bash

#构建client
cd client
yarn global add @tarojs/cli@1.2.0
yarn
yarn build:h5
cd ..

#构建server
cd server
mvn clean package -Prelease
cd ..

#运行docker-compose
docker-compose up --build
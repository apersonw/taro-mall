#!/usr/bin/env bash
# 构建
mvn clean install -Prelease

# 从pom.xml获取模块名
module_name=`grep 'artifactId' pom.xml | tr -d '/'| sed 's/<artifactId>//g' | awk 'NR==2 {print}' | sed 's/ //g'`
# 推送构建的docker镜像到阿里云服务器
module_tag=registry.cn-shanghai.aliyuncs.com/taro-mall/${module_name}:latest

docker build ./target/docker-bin/ -t ${module_tag}

docker push ${module_tag}
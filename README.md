# Taro-JD
仿京东商城

设计说明：

- 采用Sketch设计并发布切图

数据来源说明：

- 采用Python Scrapy 爬取相关数据，不共享

前端说明：

- 客户端-基于Taro+Dva

- 管理端-基于Umi

后端说明：

- 后端基于Spring Boot2，Spring WebFlux

- 数据库为MonogoDb，Redis，Elasticsearch

- 负载均衡采用nginx

- 支付仅对接支付宝和微信支付

部署说明：

- 项目部署采用Docker，服务增多后采用k8s集群部署，具体部署方式可在对应文件夹查看相关说明

```
├── LICENSE
├── README.md
├── client // 基于Taro+Dva的客户端
│   ├── config
│   ├── global.d.ts
│   ├── node_modules
│   ├── package.json
│   ├── project.config.json
│   ├── src
│   ├── tsconfig.json
│   └── yarn.lock
├── design  // 设计切图
│   ├── assets
│   ├── index.html
│   ├── links
│   └── preview
├── readmeImg
│   └── index.png
└── server // 基于Spring Boot2
    ├── pom.xml
    └── src
```

**1、首页展示**

<img src="./readmeImg/index.png" width="375px"/>
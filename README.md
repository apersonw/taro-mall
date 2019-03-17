# Taro-JD
仿京东商城前端-基于Taro+Dva

- 后端基于Spring Boot2，Spring WebFlux

- 数据库为MonogoDb，Redis，Elasticsearch

- 项目部署采用Docker，项目扩展后上kubernetes

- 负载均衡采用nginx

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
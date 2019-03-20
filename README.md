# taro-jd
仿京东商城
**1、首页展示** 

<img src="./readmeImg/index.jpg" width="375px"/>

**2、分类展示**

<img src="./readmeImg/category.jpg" width="375px"/>

设计说明：

* 采用Sketch设计并发布切图
* photoshop2009

数据来源说明：

- 采用Python爬虫爬取相关数据，不共享

前端说明：

- 客户端-基于<a href="https://taro.aotu.io/">Taro</a>+<a href="https://dvajs.com/">Dva</a>
- 管理端-基于<a href="https://umijs.org/">Umi</a>

后端说明：

- 项目框架基于<a href="https://docs.spring.io/spring/docs/current/spring-framework-reference/web-reactive.html#spring-webflux">Spring Boot2，Spring WebFlux</a>
- 数据库为MonogoDb，Redis，Elasticsearch
- 负载均衡采用nginx
- 支付仅对接支付宝和微信支付

部署说明：

- 项目前期部署采用<a href="https://docker.io/">Docker</a>，服务增多后采用集群部署

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


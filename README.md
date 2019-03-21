#### 如果你觉得还行，请给个star，感谢你的支持🙏

### 一、安装要求: Docker, Yarn or Npm, Maven 

### 二、启动说明

```bash
# clone
$ git clone https://github.com/apersonw/taro-jd.git

# run
$ ./run.sh
```

### 三、目录说明

```
.
├── client                    #客户端,访问地址：0.0.0.0:81
│   ├── Dockerfile
│   ├── docker
│   │   └── nginx.conf        #nginx配置文件
│   ├── package.json
│   ├── src                   #项目源码
├── design                    #设计切图
│   ├── assets
│   ├── index.html
│   ├── links
│   └── preview
├── docker-compose.yml        #项目docker-compose
├── manager                   #管理端,访问地址：0.0.0.0:82
│   ├── Dockerfile
│   ├── docker
│   │   └── nginx.conf        #nginx配置文件
│   ├── package.json
│   ├── public
│   ├── src
├── readmeImg                 #readme引用图片
│   ├── category.jpg
│   └── index.jpg
├── run.sh                    #启动项目运行脚本
└── server                    #restful接口服务
    ├── pom.xml
    └── src

注：数据库访问地址：0.0.0.0:27018
```

### 三、架构说明

1. #### 设计说明：

* 采用Sketch设计并发布切图

2. #### 数据来源说明：

- 采用Python爬虫爬取相关数据

3. #### 前端说明：

- 客户端-基于<a href="https://taro.aotu.io/">Taro</a>+<a href="https://dvajs.com/">Dva</a>
- 管理端-基于<a href="https://umijs.org/">Umi</a>

4. #### 后端说明：

- 项目框架基于<a href="https://docs.spring.io/spring/docs/current/spring-framework-reference/web-reactive.html#spring-webflux">Spring Cloud，Spring Boot2，Spring WebFlux</a>
- 数据库：MonogoDb，Redis，Elasticsearch
- 消息队列：RabbitMq
- 支付平台：支付宝和微信支付

5. #### 部署说明：

- 所有模块部署均采用<a href="https://docker.io/">Docker</a>


### 四、页面展示

**1、首页展示** 

<img src="./readmeImg/index.jpg" width="375px"/>

**2、分类展示**

<img src="./readmeImg/category.jpg" width="375px"/>


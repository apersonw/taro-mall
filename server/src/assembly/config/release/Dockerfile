FROM registry.cn-beijing.aliyuncs.com/rxjava/java:8_server-jre


RUN mkdir /myapp
WORKDIR /myapp

COPY base-lib base-lib
#COPY lib lib
COPY classes classes
COPY startup.sh startup.sh


EXPOSE 8080
CMD ["./startup.sh"]

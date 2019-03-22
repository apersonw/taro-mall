FROM nginx:mainline

RUN echo "Asia/Shanghai" > /etc/timezone
RUN dpkg-reconfigure -f noninteractive tzdata

COPY dist /usr/share/nginx/html
COPY docker/nginx.conf /etc/nginx/nginx.conf

#RUN apt update
#RUN apt install wget -y

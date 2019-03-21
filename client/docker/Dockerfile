FROM nginx:mainline

RUN echo "Asia/Shanghai" > /etc/timezone
RUN dpkg-reconfigure -f noninteractive tzdata


COPY nginx.conf /etc/nginx/nginx.conf
COPY dist /usr/share/nginx/html

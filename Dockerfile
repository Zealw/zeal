FROM openjdk:8-jre

## 设置所属时区
ENV TZ=Asia/Shanghai

## 创建本地和容器的连接
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone

RUN mkdir -p /zeal

WORKDIR /zeal

EXPOSE 9639

COPY ./target/zeal-1.jar ./zeal.jar

ENTRYPOINT ["java", "-Xms500m","-Xmx500m","-XX:MetaspaceSize=256m","-XX:MaxMetaspaceSize=512m", "-jar", "zeal.jar","--spring.profiles.active=test"]

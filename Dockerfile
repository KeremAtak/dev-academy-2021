FROM openjdk:8-alpine

COPY target/uberjar/dev-academy-2021.jar /dev-academy-2021/app.jar

EXPOSE 3000

CMD ["java", "-jar", "/dev-academy-2021/app.jar"]

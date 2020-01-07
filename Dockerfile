FROM maven  as builder
RUN mkdir /workdir
COPY . /workdir
RUN ls -la /workdir
RUN mvn package -f /workdir/pom.xml
RUN ls -la /workdir


FROM openjdk:8-jdk-alpine
COPY --from=builder /workdir/target/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
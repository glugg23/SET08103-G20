FROM openjdk:11
COPY ./target/SET08103-G20-jar-with-dependencies.jar /tmp
WORKDIR /tmp
ENTRYPOINT ["java", "-jar","SET08103-G20-jar-with-dependencies.jar"]

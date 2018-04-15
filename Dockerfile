FROM java:8-jdk

RUN apt-get update && apt-get install --yes sudo
RUN curl -sL https://deb.nodesource.com/setup_6.x | sudo -E bash -
RUN apt-get update && apt-get install --yes nodejs

RUN mkdir /app
WORKDIR /app

COPY . /app

WORKDIR /app/frontend

RUN npm install
RUN npm run build

RUN cp -rf ./dist/* ../backend/src/main/resources/public

WORKDIR /app

RUN ./gradlew assemble

ENTRYPOINT ["java", "-jar", "/app/backend/build/libs/backend-0.0.1-SNAPSHOT.jar"]
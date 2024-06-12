#Generate
FROM maven:3.9.6-eclipse-temurin-21-alpine as build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests
#Dockerize
FROM eclipse-temurin:21-jdk-alpine
#repertoire dans lequel docker travaille pour construire l'image
WORKDIR /app
#copié notre livrable qui est l'artefact
COPY --from=build /app/target/*.jar ./imc-app.jar
#exposer hors du conteneur afin qu'in soit accessible de l'exterieur
EXPOSE 8080 # c'est le port exposer par mon application
#commande qui va executé nore artefact qui est un fichier bianaire
ENTRYPOINT ["java", "-jar", "imc-app.jar"]
#docker build -t "nomImageGenerer:version" . : cette commande pourra creer notre image
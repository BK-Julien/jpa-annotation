#Generate Build
##Il faut toujours commenter la partie maven et commencer par la partie qui creer le jar
###FROM maven:3.9.6-eclipse-temurin-21-alpine as build
###WORKDIR /app
###COPY pom.xml .
###COPY src ./src
###RUN mvn clean package -Dmaven.test.skip=true
#Dockerize
FROM eclipse-temurin:21-jdk-alpine
#repertoire dans lequel docker travaille pour construire l'image
WORKDIR /app
#copié notre livrable qui est l'artefact
###COPY --from=build /app/target/*.jar ./data-jpa.jar
##Il faut utiliser celui-ci pour generer le jar sans le maven
COPY target/data-jpa-0.0.1-SNAPSHOT.jar data-jpa.jar
#exposer hors du conteneur afin qu'in soit accessible de l'exterieur
#c'est le port exposer par mon application
EXPOSE 8080
#commande qui va executé nore artefact qui est un fichier bianaire
ENTRYPOINT ["java", "-jar", "data-jpa.jar"]
#docker build -t "nom_de_mon_repo_sur_docker_hub/nomImageGenerer:version" . :
#cette commande pourra creer notre image
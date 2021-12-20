# Dockerfile
FROM openjdk:11
ADD target/*.jar hdb.jar
CMD java $JAVA_OPTS -jar /hdb.jar

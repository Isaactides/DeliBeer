FROM openjdk:11-jre

COPY ServicioInterno.jar webapp.jar

EXPOSE 9000

CMD java -jar webapp.jar
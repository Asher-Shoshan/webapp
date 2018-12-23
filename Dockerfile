
FROM openjdk:8-jre

# Add Maven dependencies (not shaded into the artifact; Docker-cached)
#ADD target/lib           /usr/share/myservice/lib
# Add the service itself

ARG JAR_FILE
ADD target/${JAR_FILE} /root/webapp.jar

ENTRYPOINT ["/usr/bin/java", "-jar", "/root/webapp.jar"]
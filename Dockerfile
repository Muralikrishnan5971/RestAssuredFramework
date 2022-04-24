FROM muralikrishnan5971/java8-mvn3.8.2-test
COPY src home/apiframework/src
COPY index.html home/apiframework/index.html
COPY pom.xml home/apiframework/pom.xml
COPY testng.xml home/apiframework/testng.xml
WORKDIR home/apiframework
ENTRYPOINT mvn clean test
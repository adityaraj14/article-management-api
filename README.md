# article-management-api


Built using Java 15, postgreSQL 14.2 for the database, and maven as the build tool.

Java 15 - download and install JDK
	-> https://www.oracle.com/java/technologies/javase/jdk15-archive-downloads.html
	-> verify installation - java --version

PostgreSQL - download and instsall version 14.2 
	-> if you set password to "admin" while installing, you will hopefully not need to configure DB credentials in the code when you start the app if I have set everything up correctly
	-> https://www.postgresql.org/download/windows/
	-> verify installation - psql --version

If you want, you can connect to the database using the following command
	-> psql -U postgres -W  -h localhost
	-> enter the password you set on installation when prompted

Download and install maven
	-> https://dlcdn.apache.org/maven/maven-3/3.8.5/binaries/apache-maven-3.8.5-bin.zip
	-> verify installation - mvn --version

Build and run this back-end api
	-> mvn clean install
	-> this will create an executable .jar file in the $ROOT/target folder that looks something like target\article-management-api-0.0.1-SNAPSHOT.jar
	-> you can directly run this jar using -
		-> java -jar target\article-management-api-0.0.1-SNAPSHOT.jar

In case you set the PostgreSQL password to something other than 'admin', try configuring DB username and pass inside article-management-api\src\main\resources\application.properties in the following fields -
	spring.datasource.username
	spring.datasource.password
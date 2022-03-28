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

Build and run this back-end api
	-> there is a maven wrapper "mvnw" in the root directory that can be used to build the project using  './mvnw clean install'. If this does not work download and install maven
		Download and install maven
			-> https://dlcdn.apache.org/maven/maven-3/3.8.5/binaries/apache-maven-3.8.5-bin.zip
			-> verify installation - mvn --version
			-> mvn clean install
	-> this will create an executable .jar file in the $ROOT/target folder that looks something like target\article-management-api-0.0.1-SNAPSHOT.jar
	-> you can directly run this jar using -
		-> java -jar target\article-management-api-0.0.1-SNAPSHOT.jar

In case you set the PostgreSQL password to something other than 'admin', try configuring DB username and pass inside article-management-api\src\main\resources\application.properties in the following fields -
	spring.datasource.username
	spring.datasource.password

Once the app is up, the endpoints can be accessed @
	GET - http://localhost:8080/api/articles
		-> returns all articles
	
	POST - http://localhost:8080/api/add
		-> Body: raw, data type: json
		-> Example -
			{
				"title": "article no. second",
				"authors": [
					"adi",
					"sim"
				],
				"abstrct": "this is an abstract abstract",
				"article": "this is article no. 13"
			}

	PUT - http://localhost:8080/api/update
		-> Body: raw, data type: json
		-> You need to pass the entire article object in the body including the "id" and "approved" fields. Example -
			{
				"id": 1,
				"title": "UPDATED - article no. 13",
				"authors": [
					"author1",
					"author3"
				],
				"abstrct": "this is an abstract abstract",
				"article": "this is article no. 13",
				"approved": false
			}

	DELETE - http://localhost:8080/api/delete/{id}
		-> requires ID of the article in the path
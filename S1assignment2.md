Question 2: Start the below AEM instances:        

Answer:

a) Author instance

	1. create author directory.    
	2. Copy AEM jar file and license.properties file into Author.
	3. Rename jar file with author file name detection with even port number ex. cq5-author-4502.jar, AEM-author-4502.jar
	4. Run the jar file with java -jar AEM-author-4502.jar

b) Publish instance

	1. create publish directory.    
	2. Copy AEM jar file and license.properties file into publish.
	3. Rename jar file with publish file name detection with odd port number ex. cq5-publish-4503.jar, AEM-publish-4503.jar
	4. Run the jar file with java -jar AEM-publish-4503.jar



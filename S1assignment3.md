3. Create a project with latest aem archtype

	Run the below command
	mvn -B archetype:generate -DarchetypeGroupId=com.adobe.aem -DarchetypeArtifactId=aem-project-archetype -DarchetypeVersion=49 -DappTitle="My Site" -DappId="mysite" -DgroupId="com.mysite" -DgroupId="com.mysite" -DincludeDispatcherConfig=y -DaemVersion=6.5.17

Qestion 1: Define the priority when run mode are applied using options

-> sling.properties file

Answer: Needs to edit sling.properties file under location crx-quickstart/conf and add sling.run.modes=auther,dev,development

-> system properties (-D)

Answer: java -jar  AEM-author-4502.jar -Dsling.run.modes=author,dev,development
	
-> -r option

Answer: java -jar AEM-author-4502.jar -r author,dev
	
-> file name detection

Answer:	cq5-<run-mode>-p<port-number> or AEM-<run-mode>-p<port-number>
	Example cq5-author-p4502 or aem-publish-p4503

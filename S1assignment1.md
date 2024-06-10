1. Define the priority when run mode are applied using options

	sling.properties file
	Needs to edit sling.properties file under location crx-quickstart/conf and add sling.run.modes=auther,dev,development

	system properties (-D)
	java -jar  AEM-author-4502.jar -Dsling.run.modes=author,dev,development
	
	-r option
	java -jar AEM-author-4502.jar -r author,dev
	
	file name detection
	cq5-<run-mode>-p<port-number> or AEM-<run-mode>-p<port-number>
	Example cq5-author-p4502 or aem-publish-p4503

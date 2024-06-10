package com.ttn.bootcamp.core.configuration;

import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

@ObjectClassDefinition(name = "Bootcamp OSGi Configuration Service")
public @interface BootcampOSGiConfiguration {

        @AttributeDefinition(name = "API Host Url", required = true,

        description = "Url at which api is hosted. Url must start with either http or https")

        String api_host_url() default "";
}

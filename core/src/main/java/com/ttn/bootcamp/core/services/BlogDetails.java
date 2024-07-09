package com.ttn.bootcamp.core.services;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;

public interface BlogDetails {

    Resource getResource(SlingHttpServletRequest request, String resourcePath);
}

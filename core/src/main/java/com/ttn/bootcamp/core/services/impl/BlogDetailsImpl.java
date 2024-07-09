package com.ttn.bootcamp.core.services.impl;

import com.ttn.bootcamp.core.services.BlogDetails;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.LoginException;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(service = BlogDetails.class, name = "BlogDetailsImpl")
public class BlogDetailsImpl implements BlogDetails {

    @Override
    public Resource getResource(SlingHttpServletRequest request, String resourcePath) {
        ResourceResolver resourceResolver = request.getResourceResolver();
        Resource resource = resourceResolver.getResource(resourcePath);
        return resource;
    }
}

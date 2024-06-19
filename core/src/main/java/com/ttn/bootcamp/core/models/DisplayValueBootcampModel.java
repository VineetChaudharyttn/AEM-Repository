package com.ttn.bootcamp.core.models;

import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;
import com.day.cq.wcm.api.designer.Design;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ttn.bootcamp.core.services.MySimpleService;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ValueMap;
import org.apache.sling.models.annotations.*;
import org.apache.sling.models.annotations.injectorspecific.*;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import static org.apache.sling.api.resource.ResourceResolver.PROPERTY_RESOURCE_TYPE;

@Model(adaptables = SlingHttpServletRequest.class, adapters = DisplayValueBootcampModel.class)
public class DisplayValueBootcampModel {
    @Inject
    @Via("resource")
    private String injectedValue;
    @Inject
    @Via("resource")
    @Required
    private String requiredTest;
    @Inject
    @Via("resource")
    @Optional
    private String optionalTest;

    @OSGiService(filter = "(component.name=serviceDemoImpl)")
    private MySimpleService mySimpleService;

    @ScriptVariable
    Page currentPage;

    private String message;

    @PostConstruct
    protected void init() {
        message = "Initialising from Bootcamp PostConstruct.";
    }
    public String getInjectedValue() {
        return injectedValue;
    }
    public String getPageTitle() {
        return currentPage.getPageTitle();
    }


    public String getRequiredTest() {
        return requiredTest;
    }

    public String getOptionalTest() {
        return optionalTest;
    }
    public String getMessage() {
        return message;
    }
    public String getUrl() {
        return mySimpleService.fetchURL();
    }

}

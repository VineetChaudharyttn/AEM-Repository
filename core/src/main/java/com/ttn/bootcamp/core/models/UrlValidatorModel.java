package com.ttn.bootcamp.core.models;

import org.apache.commons.lang.StringUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Optional;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

@Model(adaptables = {SlingHttpServletRequest.class, Resource.class}, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class UrlValidatorModel {
    private boolean isAemLink;

    @Inject
    @Optional
    public String link;

    @PostConstruct
    public void init() {
        isAemLink = StringUtils.startsWith(link,"/content");
    }

    public boolean getIsAemLink() {
        return isAemLink;
    }

    public String getValidLink() {
        return isAemLink ? link + ".html" : link;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}


package com.ttn.bootcamp.core.models;


import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Via;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;
import javax.inject.Inject;
import java.util.List;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class BlogFeedsModel {

    @Inject
    public List<Feed> feed;

    public List<Feed> getFeed() {
        return feed;
    }

    public void setFeed(List<Feed> feeds) {
        this.feed = feeds;
    }
}

package com.ttn.bootcamp.core.models;

import com.ttn.bootcamp.core.services.BlogDetails;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Default;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Via;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;
import org.apache.sling.models.annotations.injectorspecific.ScriptVariable;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import java.util.*;

@Model(adaptables = SlingHttpServletRequest.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class LatestThreeFeedModel {

    @Inject
    @Via("resource")
    String blogsPath;

    @Inject
    @Via("resource")
    @Default(values= "false")
    Boolean showtopthree;

    @OSGiService
    BlogDetails blogDetails;

    @ScriptVariable
    SlingHttpServletRequest request;

    Resource resource;

    @PostConstruct
    public void init() {
        resource = blogDetails.getResource(request, blogsPath);
    }

    public List<Feed> getLatestThreeFeed() {
        List<Feed> feedList = new ArrayList<>();
        if (resource == null) {
            return feedList;
        }
        resource.getChildren().forEach(res -> {
            Feed feed = new Feed();
            feed.setFileReferencefeed(res.getResourceResolver().getResource(res.getPath()+"/jcr:content/root/responsivegrid/blogsimpleimage").getValueMap().get("fileReference").toString());
            feed.setBloglogo(res.getResourceResolver().getResource(res.getPath()+"/jcr:content/root/responsivegrid/blogsimpleimage").getValueMap().get("bloglogo").toString());
            feed.setBlogtitle(res.getResourceResolver().getResource(res.getPath()+"/jcr:content/root/responsivegrid/blogheading").getValueMap().get("heading").toString());
            feed.setDate(((GregorianCalendar)res.getResourceResolver().getResource(res.getPath()+"/jcr:content/root/responsivegrid/blogheading").getValueMap().get("date")).getTime());
            feed.setDetailedblog(res.getResourceResolver().getResource(res.getPath()+"/jcr:content/root/responsivegrid/blogabout").getValueMap().get("details").toString());
            feed.setBlogheading(res.getChild("jcr:content").getValueMap().get("jcr:title").toString());
            feed.setLink(res.getPath());

            feedList.add(feed);
        });
        feedList.sort(Comparator.comparing(Feed::getDate));
        return showtopthree?feedList.subList(0,3):feedList;
    }
}

package com.ttn.bootcamp.core.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import javax.inject.Inject;
import java.util.Date;


@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class Feed {

    @Inject
    private String fileReferencefeed;

    @Inject
    private String blogheading;

    @Inject
    private String blogtitle;

    @Inject
    private Date date;

    @Inject
    private String detailedblog;

    @Inject
    private String link;

    @Inject
    private String bloglogo;

    public String getFileReferencefeed() {
        return fileReferencefeed;
    }

    public void setFileReferencefeed(String fileReferencefeed) {
        this.fileReferencefeed = fileReferencefeed;
    }

    public String getBlogheading() {
        return blogheading;
    }

    public void setBlogheading(String blogheading) {
        this.blogheading = blogheading;
    }

    public String getBlogtitle() {
        return blogtitle;
    }

    public void setBlogtitle(String blogtitle) {
        this.blogtitle = blogtitle;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDetailedblog() {
        return detailedblog;
    }

    public void setDetailedblog(String detailedblog) {
        this.detailedblog = detailedblog;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public void setBloglogo(String bloglogo) {
        this.bloglogo = bloglogo;
    }
    public String getBloglogo() {
        return bloglogo;
    }
}

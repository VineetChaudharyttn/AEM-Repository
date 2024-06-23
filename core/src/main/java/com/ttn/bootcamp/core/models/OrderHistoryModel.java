package com.ttn.bootcamp.core.models;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

@Model(adaptables = SlingHttpServletRequest.class)
public class OrderHistoryModel {
@Inject
private SlingHttpServletRequest request;

private Resource resource;

    @PostConstruct
    public void init() {
        resource = this.request.getResourceResolver().getResource("/content/ttnBootcamp/fr/orderhistory/jcr:content");
    }

    public String getItem() {
        return resource.getValueMap().get("item", String.class);
    }
    public Integer getPrice() {
        return resource.getValueMap().get("price", Integer.class);
    }
    public Integer getQuantity() {
        return resource.getValueMap().get("quantity", Integer.class);
    }
    public String getState() {
        return resource.getValueMap().get("state", String.class);
    }
    public String getBill() {
        Integer totalBill = getPrice()*getQuantity();
        return totalBill.toString();
    }

}

package com.ttn.bootcamp.core.models;


import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;
import org.osgi.service.component.annotations.Activate;

import javax.annotation.PostConstruct;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Model(adaptables = Resource.class)
public class CurrentTimeModel {
    private String currentTime;
    private Map<String,String> currentMap;

    @SlingObject
    private Resource resource;

    @PostConstruct
    @Activate
    protected void init() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        currentTime = sdf.format(new Date());

        Map<String,String> map = new HashMap<>();
        map.put("Attr1","val1");
        map.put("Attr2","val2");
        map.put("Attr3","val3");
        map.put("Attr4","val4");
        map.put("Attr5","val5");
        currentMap = map;
    }

    public String getCurrentTime() { return  currentTime; }

    public Map<String,String> getCurrentMap() {
        return currentMap;
    }
}

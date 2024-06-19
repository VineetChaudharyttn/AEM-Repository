package com.ttn.bootcamp.core.services.impl;


import com.ttn.bootcamp.core.configuration.BootcampOSGiConfiguration;
import com.ttn.bootcamp.core.services.MySimpleService;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.metatype.annotations.Designate;

@Component(service = MySimpleService.class, immediate = true,name = "serviceA")
@Designate(ocd = BootcampOSGiConfiguration.class)
public class MySimpleServiceImpl implements MySimpleService {

    private String hostUrl;

    @Activate
    @Modified
    public void activate(BootcampOSGiConfiguration config) {
        hostUrl = config.api_host_url();
    }

    @Deactivate
    public void deactivate(BootcampOSGiConfiguration config) {
        hostUrl = "";
    }

    @Override
    public String fetchURL() {
        return hostUrl;
    }
}

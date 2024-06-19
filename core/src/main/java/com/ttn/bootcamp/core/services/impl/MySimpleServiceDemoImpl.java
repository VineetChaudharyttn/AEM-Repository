package com.ttn.bootcamp.core.services.impl;

import com.ttn.bootcamp.core.configuration.BootcampOSGiConfiguration;
import com.ttn.bootcamp.core.services.MySimpleService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.metatype.annotations.Designate;

@Component(service = MySimpleService.class, immediate = true,name = "serviceDemoImpl")
@Designate(ocd = BootcampOSGiConfiguration.class)
public class MySimpleServiceDemoImpl implements MySimpleService {
    @Override
    public String fetchURL() {
        return "Demo text not an url for web";
    }
}

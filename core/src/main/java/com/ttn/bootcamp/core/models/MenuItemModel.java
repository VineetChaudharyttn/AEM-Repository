package com.ttn.bootcamp.core.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import java.util.List;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class MenuItemModel {
    @Inject
    public List<MenuModel> menuItem;

    @PostConstruct

    public List<MenuModel> getMenuItem() {
        return menuItem;
    }

    public void setMenuItem(List<MenuModel> menuItem) {
        this.menuItem = menuItem;
    }
}

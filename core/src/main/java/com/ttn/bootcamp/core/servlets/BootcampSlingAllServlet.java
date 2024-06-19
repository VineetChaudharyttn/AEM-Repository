package com.ttn.bootcamp.core.servlets;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.json.JSONException;
import org.json.JSONObject;
import org.osgi.service.component.annotations.Component;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import java.io.IOException;

@Component(immediate = true, service = {Servlet.class},
property = {
        "sling.servlet.methods="+ HttpConstants.METHOD_POST,
        "sling.servlet.paths=/bootcamp/testSlingAllForPost",
        "sling.servlet.extension=html"
})

public class BootcampSlingAllServlet extends SlingAllMethodsServlet {

    @Override
    protected void doPost(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        JSONObject json = new JSONObject();
        try {
            json.put("status","success");
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
        response.getWriter().write(json.toString());
    }
}

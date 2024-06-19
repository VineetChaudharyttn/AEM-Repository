package com.ttn.bootcamp.core.servlets;

import org.apache.commons.io.IOUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.apache.sling.servlets.annotations.SlingServletResourceTypes;
import org.json.JSONException;
import org.json.JSONObject;
import org.osgi.service.component.annotations.Component;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import java.io.IOException;
import java.util.Map;

@Component(immediate = true, service = {Servlet.class})
@SlingServletResourceTypes(
        resourceTypes = "/contact/us",
        methods = "POST"
)
public class ContactUsServlet extends SlingAllMethodsServlet {
    @Override
    protected void doPost(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServletException, IOException {
        String body = IOUtils.toString(request.getReader());
        try {
            JSONObject json = new JSONObject(body);
//            MyObject myObject = new Gson().fromJson(jsonString, MyObject.class);
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
        response.setContentType("application/json");
        JSONObject json = new JSONObject();
        try {
            json.put("status","ok");
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
        response.getWriter().write(json.toString());
    }
}

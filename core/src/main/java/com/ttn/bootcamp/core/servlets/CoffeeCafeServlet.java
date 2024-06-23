package com.ttn.bootcamp.core.servlets;

import org.apache.commons.io.IOUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.ModifiableValueMap;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.apache.sling.servlets.annotations.SlingServletResourceTypes;
import org.json.JSONException;
import org.json.JSONObject;
import org.osgi.service.component.annotations.Component;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import java.io.IOException;

@Component(service = {Servlet.class})
@SlingServletResourceTypes(
        resourceTypes = "/order/submit",
        methods = HttpConstants.METHOD_POST
)
public class CoffeeCafeServlet extends SlingAllMethodsServlet {

    @Override
    protected void doPost(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServletException, IOException {
        String body = IOUtils.toString(request.getReader());
        ResourceResolver resourceResolver = request.getResourceResolver();
        Resource orderResource = resourceResolver.getResource("/content/ttnBootcamp/fr/orderhistory/jcr:content");
        JSONObject json = null;
        try {
            json = new JSONObject(body);
//            MyObject myObject = new Gson().fromJson(jsonString, MyObject.class);
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
        if (orderResource != null) {
            ModifiableValueMap properties = orderResource.adaptTo(ModifiableValueMap.class);
            try {
                properties.put("item", json.get("item"));
            properties.put("price", json.get("price"));
            properties.put("quantity", json.get("quantity"));
            properties.put("state", json.get("state"));
            resourceResolver.commit();
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        } else {
                response.getWriter().println("Node /content/my-test/jcr:content not found.");
        }
        response.setContentType("application/json");
        JSONObject responceJson = new JSONObject();
        try {
            responceJson.put("status","ok");
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
        response.getWriter().write(responceJson.toString());
    }
}

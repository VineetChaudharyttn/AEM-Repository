package com.ttn.bootcamp.core.servlets;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.apache.sling.servlets.annotations.SlingServletResourceTypes;
import org.osgi.service.component.annotations.Component;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@Component(immediate = true,service = { Servlet.class })
@SlingServletResourceTypes(
        resourceTypes="/bootcamp/demo",
        methods= "GET")
public class BootcampDemoServlet extends SlingSafeMethodsServlet {

    @Override
    protected void doGet( SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServletException, IOException {
        List<String> bootcampStudents = new ArrayList<>();
        bootcampStudents.add("Priya Gupta");
        bootcampStudents.add("Deepankshi Arora");
        bootcampStudents.add("Vineet Chaudhary");
        PrintWriter writer = response.getWriter();
        writer.println(bootcampStudents);

    }
}

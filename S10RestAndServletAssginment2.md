Question 2: Post Servlet - Create a contact us form. Send form data (json) from front end and Save to AEM Node.

Answer: Following steps need to be perform:-

Step 1: create a post servlet for record contact us query.

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

Step 2: Create a html page to contact us.

    <h3>Contact Form</h3>

    <div class="container">
            <label for="fname">First Name</label>
            <input type="text" id="fname" name="firstname" placeholder="Your name..">
    
            <label for="lname">Last Name</label>
            <input type="text" id="lname" name="lastname" placeholder="Your last name..">
    
            <label for="country">Country</label>
            <select id="country" name="country">
                <option value="australia">Australia</option>
                <option value="canada">Canada</option>
                <option value="usa">USA</option>
            </select>
    
            <label for="subject">Subject</label>
            <textarea id="subject" name="subject" placeholder="Write something.." style="height:200px"></textarea>
    
            <input onclick="contactUs()" type="submit" value="Submit">
        <h1 class="modal-box" />
    </div>

Step 3: add css to html.

    body {font-family: Arial, Helvetica, sans-serif;}
    * {box-sizing: border-box;}
    
    input[type=text], select, textarea {
        width: 100%;
        padding: 12px;
        border: 1px solid #ccc;
        border-radius: 4px;
        box-sizing: border-box;
        margin-top: 6px;
        margin-bottom: 16px;
        resize: vertical;
    }
    
    input[type=submit] {
        background-color: #04AA6D;
        color: white;
        padding: 12px 20px;
        border: none;
        border-radius: 4px;
        cursor: pointer;
    }
    
    input[type=submit]:hover {
        background-color: #45a049;
    }
    
    .container {
        border-radius: 5px;
        background-color: #f2f2f2;
        padding: 20px;
    }

Step 4: create a js file to hit the contact us end point with details.

    var contactUs = function () {
        var firstname = $('#fname').val();
        var lastname = $('#lname').val();
        var country = $('#country').val();
        var subject = $('#subject').val();
    
        $.ajax
        ({
            url: '/content/ttnBootcamp/fr/en/api/contactUs',
            data: JSON.stringify({"FirstName": firstname, "LastName": lastname, "country": country, "subject": subject}),
            contentType: "application/json; charset=utf-8",
            crossDomain: true,
            dataType: "json",
            type: 'post',
            success: function (result) {
                $('.modal-box').text(result.get("status"));
            }
        });
    }


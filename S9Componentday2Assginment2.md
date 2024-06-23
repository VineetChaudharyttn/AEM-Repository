Question 2: Create component Important links. Author can add  title and a list of important links. Author can add as many links as he wants. If the link added by author is internal link, we need to add “HTML” extension to the link but if the link is an external link(i.e. Outside of AEM) do not add the extension. Also For each link authoring, he gets the following fields: 1. Title  2. link  3. dropdown to select whether the link should open in new tab or same tab.
Note: Read Resource resolver API and Resource API to check if a link is an AEM internal link or external.

Solution: Create a component named as Important links.

Step 1: create HTML file

    <sly data-sly-use.clientlib="core/wcm/components/commons/v1/templates/clientlib.html">
        <sly data-sly-call="${clientlib.css @ categories='ttnBootcamp.importantlinks'}"/>
    </sly>
    <div class="card" style="transition: 0.3s;width: 40%;" onMouseOut="this.style.box-shadow: 0 4px 8px 0 rgba(0,0,0,0.2);" onMouseOver="this.style.box-shadow: 0 8px 16px 0 rgba(0,0,0,0.2);">
        <div class="container" style="padding: 2px 16px;">
            <h3 class="mb-0">
                <p class="text-dark">${properties.title}</p>
            </h3>
            <div data-sly-list="${properties.link}">
                <a href="http://${item}">${item}</a>
                <br/>
            </div>
        </div>
    </div>

Step 2: Create cq:Dialog with .content.xml have below xml

    <?xml version="1.0" encoding="UTF-8"?>
    <jcr:root xmlns:sling="http://sling.apache.org/jcr/sling/1.0" xmlns:cq="http://www.day.com/jcr/cq/1.0"
              xmlns:jcr="http://www.jcp.org/jcr/1.0" xmlns:nt="http://www.jcp.org/jcr/nt/1.0"
              jcr:primaryType="nt:unstructured"
              jcr:title="Properties"
              sling:resourceType="cq/gui/components/authoring/dialog">
        <content
                jcr:primaryType="nt:unstructured"
                sling:resourceType="granite/ui/components/coral/foundation/fixedcolumns">
            <items jcr:primaryType="nt:unstructured">
                <column
                        jcr:primaryType="nt:unstructured"
                        sling:resourceType="granite/ui/components/coral/foundation/container">
                    <items jcr:primaryType="nt:unstructured">
                        <text
                                jcr:primaryType="nt:unstructured"
                                sling:resourceType="granite/ui/components/coral/foundation/form/textfield"
                                fieldLabel="Title"
                                name="./title"/>
                        <keywords jcr:primaryType="nt:unstructured"
                                  sling:resourceType="granite/ui/components/foundation/form/multifield"
                                  fieldLabel="Links"
                                  metaType="link"
                                  name="./link"
                                  renderReadOnly="true">
                            <field
                                    jcr:primaryType="nt:unstructured"
                                    sling:resourceType="granite/ui/components/foundation/form/textfield"
                                    name="./link"/>
                        </keywords>
                        <select
                                jcr:primaryType="nt:unstructured"
                                sling:resourceType="granite/ui/components/coral/foundation/form/select"
                                fieldLabel="Link should be open as"
                                name="./openstate">
                            <items jcr:primaryType="nt:unstructured">
                                <option1
                                        jcr:primaryType="nt:unstructured"
                                        text="New tab"
                                        value="New tab"/>
                                <option2
                                        jcr:primaryType="nt:unstructured"
                                        text="Same tab"
                                        value="Same tab"/>
                            </items>
                        </select>
                    </items>
                </column>
            </items>
        </content>
    </jcr:root>

Step 3: create a css file in client libs with following css
    
    .card {
    box-shadow: 0 4px 8px 0 rgba(0,0,0,0.2);
    transition: 0.3s;
    width: 40%;
    }
    
    .card:hover {
    box-shadow: 0 8px 16px 0 rgba(0,0,0,0.2);
    }
    
    .container {
    padding: 2px 16px;
    }


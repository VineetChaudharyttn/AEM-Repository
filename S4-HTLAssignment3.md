Question3: Read the color property from the current node and set it as the background of the page.

Answer: 
Step 1: Add a color property in the page jcr:content

![img_2.png](img_2.png)

Step 2: Use that property is css and apply on page body.

    <style>
        body {

            background-color:${pageProperties.color @ context='styleToken'};
        }
    </style>

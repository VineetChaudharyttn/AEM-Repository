Question 1: Create a component with a dialog and having color drop down (green, blue, black etc) and one rich text editor for authoring text.
This component is supposed to render text and apply chosen color to text.

Answer: 

Step 1: create a node with primaryType `cq:component` and create a html file into that.

![img_26.png](img_26.png)

Step 2: Create a node with name `cq:dialog` into the component node of type `nt:unstructured` and add property `sling:resourceType` with value `cq/gui/components/authoring/dialog`, `jcr:title` with value `Properties`.

![img_27.png](img_27.png)

Step 3: Create a node with name `content` under the `cq:dialog` node of type `nt:unstructured` and add property `sling:resourceType` with value `granite/ui/components/coral/foundation/fixedcolumns`.

![img_28.png](img_28.png)

Step 4: Create a node with name `items` under the `content` node of type `nt:unstructured`.

![img_29.png](img_29.png)

Step 5: Create a node with name `column` under the `items` node of type `nt:unstructured` and add property `sling:resourceType` with value `granite/ui/components/coral/foundation/container`.

![img_30.png](img_30.png)

Step 6: Create a node with name `items` under the `column` node of type `nt:unstructured`.

![img_31.png](img_31.png)

Step 7: Create two nodes one for `text` and second for `select` both should be `nt:unstructured` and add property `fieldlable` with value `Text`/`Color`, `name` with value `./text`/`./color`, `sling:resourceType` with value `granite/ui/components/coral/foundation/form/textfield`/`granite/ui/components/coral/foundation/form/select`.

![img_32.png](img_32.png)

Step 6: Create a node with name `items` under the `select` node of type `nt:unstructured`.

![img_33.png](img_33.png)

Step 8: Create a node with name `green`,`blue`,`black` under the `items` node of type `nt:unstructured` and add property `text` with value `green`,`blue`,`black`.

![img_34.png](img_34.png)

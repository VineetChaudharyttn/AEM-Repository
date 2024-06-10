Taking up a list of potential scripts for a request to a resource whose sling:resource type is example/sample and the request selectors are "print.a4" and the request extension is "html". What would be the order in which these scripts would be called ?

(0) GET.jsp

(1) sample.jsp

(2) html.jsp

(3) print.jsp

(4) print.html.jsp

(5) print/a4.jsp

(6) print/a4/html.jsp 

(7) print/a4.html.jsp

Answer: The order will be (starting with the best): (7)-(6)-(5)-(4)-(3)-(2)-(1)-(0).

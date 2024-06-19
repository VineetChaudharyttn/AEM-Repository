Question 2: Create one sling model and display the values.Show usecase and describe these annotations @Inject, @PostConstruct, @OsgiService, @ScriptVariable, @Optional/@Required.

Answer:  

@Inject:- Inject annotation is used to inject properties from resource.
e.g.

    @Inject
    @Via("resource")
    private String injectedValue;

@PostConstruct:- Post Construct is used to execute a block of code in after all dependencies injection. So, it is used when required to perform any operation after property injection.

    @PostConstruct
    protected void init() {
        message = "Initialising from Bootcamp PostConstruct.";
    }

@OsgiService:- OSGiService is used to inject any service into a model.

    @OSGiService(filter = "(component.name=serviceDemoImpl)")
    private MySimpleService mySimpleService;

@ScriptVariable:- ScriptVariable is used to inject any object is available in HTL.

    @ScriptVariable
    Page currentPage;

@Optional/@Required:- @Optional is used with @Inject to ensure that if the property does not exist, the model will not break that will ignore the property injection.
And for @Required is used to ensure that we should have that particular property.

    @Inject
    @Via("resource")
    @Required
    private String requiredTest;
    @Inject
    @Via("resource")
    @Optional
    private String optionalTest;

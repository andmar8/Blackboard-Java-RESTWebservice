Blackboard-Java-RESTWebservice
==============================

Bare with me, it'll take a while to get all the required source and dependancies on github and then a bit of documentation to make this useful...

Documentation can still be found in the project's original home on oscelot... http://projects.oscelot.org/gf/project/webservices/, this will change "at some point in the future"

This project is basically a different front to the SOAP service, all of the back end code has been written, it just needs the REST interfaces joining to it to expose the code.

Dependencies
------------

* [Jersey 1.5](https://jersey.java.net/) - but you should probably try with a much newer version!
* Jersey Contribs - if you download the full jersey with all dependencies you'll see there is a seperate directory for contributed jars, this is what this is; essentially just include everything in the full jersey download.
* Blackboard jar files (remember to NOT compile these into your jar!)
* [Blackboard-Java-WebservicesBBHelper](https://github.com/andmar8/Blackboard-Java-WebservicesBBHelper)
* Blackboard-Java-WebservicesBBSerializableObjectsREST - coming soon
* [Blackboard-Java-WebservicesBBSerializableObjects](https://github.com/andmar8/Blackboard-Java-WebservicesBBSerializableObjects)
* [Blackboard-Java-WebservicesBBSecurity](https://github.com/andmar8/Blackboard-Java-WebservicesBBSecurity)
* [Blackboard-Java-WebservicesOAuthREST](https://github.com/andmar8/Blackboard-Java-WebservicesOAuthREST)
* [Blackboard-Java-WebservicesOAuth](https://github.com/andmar8/Blackboard-Java-WebservicesOAuth)

How to compile
--------------

Create/find jars for all of the above and add to your project

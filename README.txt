INFO:
    * Developed with:
       - JDK 17.0.8.1
       - Maven 3.9.6

    * address.service.url property in application.yml("http://65cb7f92efec34d9ed87a5b4.mockapi.io/address") corresponds to a service generated with mockapi.io with the following schema:
       - _id              ObjectId
       - street           Fakers.js           address.street
       - city             Fakers.js           address.city
       - country          Fakers.js           address.country
       - zipCode          Fakers.js           address.zipCode
       - state            Fakers.js           address.state

    * BUILD 
        - TO INSTALL LOCALLY:
            "E:\Personale\Progetti POC\poc-cache\mvnw.cmd" -s "E:/Sviluppo/Maven/apache-maven-3.9.6/conf/settings.xml" install -f "e:\Personale\Progetti POC\poc-cache\pom.xml"

    * RUN
        - TO RUN LOCALLY:
            "E:\Personale\Progetti POC\poc-cache\mvnw.cmd" -s "E:/Sviluppo/Maven/apache-maven-3.9.6/conf/settings.xml" spring-boot:run -f "e:\Personale\Progetti POC\poc-cache\pom.xml"

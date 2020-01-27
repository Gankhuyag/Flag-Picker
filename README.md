 
 
I. The database name in MySQL server is   "flagDB" 

II. REST API Endpoints:

GET : all list 

http://localhost:8080/list

GET : Continent list by letters 

Using @PathVariable = Retrieve by Value
http://localhost:8080/list/Asia
http://localhost:8080/list/As
Using @RequestParam  = Retrieve by Query Parameter
http://localhost:8080/listing?continent=Asia
http://localhost:8080/listing?continent=A

GET : Country List on a selected Continent

Using @PathVariable = Retrieve by Value
http://localhost:8080/list/countries/Asia
http://localhost:8080/list/countries/As
Using @RequestParam  = Retrieve by Query Parameter
http://localhost:8080/listing/countries?continent=Asia
http://localhost:8080/listing/countries?continent=A

GET:  Flag list on a selected continent and country.

Using @PathVariable = Retrieve by Value
http://localhost:8080/list/flag/Asia/India
http://localhost:8080/list/flag/As/Ind
Using @RequestParam  = Retrieve by Query Parameter
http://localhost:8080/listing/flag/?continent=asia&country=India
http://localhost:8080/listing/flag/?continent=as&country=In


POST

http://localhost:8080/create      // send json as body 


III. Design pattern used
I used the observable pattern to inform that the new countries information is created and logged 
in this  REST based service architecture. Observable states that changed are, creating a new country 
information, and selected countries. This  information are atached into subject. 

Package for Observable pattern is com.flags.observer

VI.Junit test

I created the Junit test on the REST services for ContinentConroller.java. The name of class is 
ContinentConrollerTest.java. I used RestAssured Junit untegration frame work to check the REST http GET 
requests.
  

 # Flaf-Picker
I. The database name in MySQL server is   "flagDB" 

II. REST API Endpoints:

GET : all list 

http://localhost:8080/list

GET : Continent list by letters 

Using @PathVariable = Retrieve by Value
http://localhost:8080/list/Asia
http://localhost:8080/list/As
Using @RequestParam  = Retrieve by Query Parameter
http://localhost:8080/listing?continent=Asia
http://localhost:8080/listing?continent=A

GET : Country List on a selected Continent

Using @PathVariable = Retrieve by Value
http://localhost:8080/list/countries/Asia
http://localhost:8080/list/countries/As
Using @RequestParam  = Retrieve by Query Parameter
http://localhost:8080/listing/countries?continent=Asia
http://localhost:8080/listing/countries?continent=A

GET:  Flag list on a selected continent and country.

Using @PathVariable = Retrieve by Value
http://localhost:8080/list/flag/Asia/India
http://localhost:8080/list/flag/As/Ind
Using @RequestParam  = Retrieve by Query Parameter
http://localhost:8080/listing/flag/?continent=asia&country=India
http://localhost:8080/listing/flag/?continent=as&country=In


POST

http://localhost:8080/create      // send json as body 


III. Design pattern used
I used the observable pattern to inform that the new countries information is created and logged 
in this  REST based service architecture. Observable states that changed are, creating a new country 
information, and selected countries. This  information are atached into subject. 

Package for Observable pattern is com.flags.observer

VI.Junit test

I created the Junit test on the REST services for ContinentConroller.java. The name of class is 
ContinentConrollerTest.java. I used RestAssured Junit untegration frame work to check the REST http GET 
requests.
  

 # Flaf-Picker

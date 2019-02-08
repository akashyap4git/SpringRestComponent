# SpringRestComponent

This is Spring Rest Application with Spring Security and Spring Data and JPA

First create User and Role using 
http://localhost:8484/service/admin/createUserAndRole which will be authenticated by In Memory Authetication Provider in Spring Security.

Then You can add more User and Role using POSTMAN as:

POST : http://localhost:8484/service/admin/createUserAndRole
{
 "username" : "akashyap",
 "password" : "akashyap",
 "roles" : ["USER"]
}


Then You can create customer as:
POST: http://localhost:8484/service/myapp/createMember

This will get authorized by Jdbc Authentication Provider onwards with given user and role.
Basically, It is Authorization Type : Basic
and username and password which will be given in createUserAndRole


{
 "firstName" : "Ambarish",
 "lastName" : "Kashyap",
 "credential" : {
 "username" : "ak4@gmail.com",
 "password" : "password"
 },
 "dateOfBirth" : "1983-02-22",
 "emailId" : "ak4@gmail.com",
 "phoneNumber" : "9590423072",
 "address" : {
	"addressLine1" : "DTA",
	"addressLine2" : "K R PURAM",
	"city" : "Bangalore",
	"state" : "Karnataka",
	"country" : "INDIA",
	"zipCode" : 560049
 },
 "gender" : "MALE"
}

OR
<member>
<firstName>Ambarish</firstName>
<lastName>Kashyap</lastName>
<credential>
	<username>ak4@gmail.com</username>
	<password>password</password>
</credential>
<dateOfBirth>1983-02-22</dateOfBirth>
<emailId>ak4@gmail.com</emailId>
<phoneNumber>9590423072</phoneNumber>
<address>
	<addressLine1>DTA</addressLine1>
	<addressLine2>K R Puram</addressLine2>
	<city>Bangalore</city>
	<state>Karnataka</state>
	<country>INDIA</country>
	<zipCode>560049</zipCode>
</address>
<gender>MALE</gender>
</member>


You can fetch customer as:
GET: http://localhost:8484/service/myapp/fetchMember/82cdf146-9c84-4492-b029-73169ba8ffed



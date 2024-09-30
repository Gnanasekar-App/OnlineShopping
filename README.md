# OnlineShopping.
Technologies used are Spring Boot Framework, STS IDE, MySQL, JPA, RESTful APIs. There are 6 model classes in the project User, Customer, Address, Product, Cart and Order. The main goal of this project is to create a series of backend API’s so that the user can access the functionalities of the various types of functions of the models just like the functionalities one can get while shopping from any online website.
Entity Relationship Diagram
Annotation 2022-08-17 114603

Tech Stacks & Tools Used
Tech Stacks:

Java

MySQL

Spring

SpringBoot

Hibernate

Tools:

Spring Tool Suite

Swagger

Postman

Classes under the Model package
Address.java

User.java

Customer.java

MyOrder.java

Products.java

CategoryEnum

Cart.java

Some Endpoints to access the functionalities
Link to Swagger: http://localhost:8088/swagger-ui/index.html#/

To register as a user:

http://localhost:8088/regisrtration

To login as a user:

http://localhost:8088/login

To add new products

http://localhost:8088/newproducts

To get customer

http://localhost:8088/{customerId}

To add products to cart:

http://localhost:8088/Cart/addtocart/{id}/{custId}

To get all address:

http://localhost:8088/getAll

THANK YOU

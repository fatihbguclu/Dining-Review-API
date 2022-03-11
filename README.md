# Dining Review API
Portfolio project for the Codecademy Spring framework course. The goal is to build an API that can be used to rate different restaurants' ability to handle different types of allergies. In this project peanut, egg and dairy allergies are only taken into account.

## Project Objectives:
* Construct a RESTful web API with data persistence using Spring and Spring Data JPA
* Configure application properties for certain dependencies, including the H2 embedded database
* Define the entities that comprise this application scenario
* Define the repositories that enable creating, updating, and querying these different entities
* Define the API contracts that will enable this application scenario
* Leverage the convenience of Lombok
* Use cURL to test your API scenarios

## API End Points

### For Restaurants
```shell
Get All Restaurants:
curl -X GET http://localhost:8080/api/restaurants

Search a Spesific Restaurant by its ZipCode
curl -X GET http://localhost:8080/api/restaurants/{zipcode}

Post Request for create new resturant
curl -X Get "Content-Type: application/json" -d '{"name":"restaurantName","city":"restaurantCity","state":"restaurantState","zipcode":"restaurantZipcode"}' http://localhost:8080/restaurants
```
### For Reviews
```shell
Get All Reviews:
curl -X GET http://localhost:8080/api/reviews

Get All Pending Reviews
curl -X GET http://localhost:8080/api/restaurants/pending

Get Review by its ID
curl -X GET http://localhost:8080/api/restaurants/{id}

Put Mapping for Approve a Review
curl -X PUT http://localhost:8080/api/restaurants/{id}/approve

Put Mapping for Reject a Review
curl -X PUT http://localhost:8080/api/restaurants/{id}/reject
```

### For Users
```shell
Get All Users:
curl -X GET http://localhost:8080/api/users

Get User by its name
curl -X GET http://localhost:8080/api/users/{name}

```

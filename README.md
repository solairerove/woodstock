# Woodstock

___

#### How start:

* `gradle build && java -jar build/libs/woodstock-*.jar`
* `gradle bootRun`

____

#### Standard rest controllers:

* `api/model` - return random generated model

___

#### [Repository rest resource](https://spring.io/guides/gs/accessing-mongodb-data-rest/):

* `curl -i -X POST -H "Content-Type:application/json" -d '{  "firstName" : "Richie",  "lastName" : "Havens" }' http://localhost:8080/people`
* `curl http://localhost:8080/people/search/findByLastName?name=Havens`
* `curl -X PUT -H "Content-Type:application/json" -d '{ "firstName": "Tim", "lastName": "Hardin" }' http://localhost:8080/people/***`
* `curl -X PATCH -H "Content-Type:application/json" -d '{ "firstName": "James Timothy" }' http://localhost:8080/people/***`
* `curl -X DELETE http://localhost:8080/people/***`
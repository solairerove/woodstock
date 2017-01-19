# Woodstock

*You should see [hrms](https://github.com/vlsidlyarevich/unity) module. There will be some integration in future.*
___

#### How to start:

* `mvn spring-boot:run`
* `mvn clean install && jar -jar target/*.jar`

___

#### Jacoco test coverage:

* `mvn clean test jacoco:report -Ptest`
* `target/site/jacoco/index.html`

___

#### Sonar analyze:

* `mvn clean install -Ptest`
* `mvn sonar:sonar`

___

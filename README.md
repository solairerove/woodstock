# Woodstock
[![Dependency Status](https://www.versioneye.com/user/projects/57e682d979806f002f4ab840/badge.svg?style=flat-square)](https://www.versioneye.com/user/projects/57e682d979806f002f4ab840)

*You should see [hrms](https://github.com/vlsidlyarevich/unity) module. There will be some integration in future.*
___

#### How to start:

* `mvn spring-boot:run`
* `mvn clean install && jar -jar target/*.jar`

___

#### Import to neo4j:

* `pip install py2neo`
* `cp /usr/lib/python2.7/py2neo /usr/lib/python3.5/` - if this shit wan't install
* `alias python=python3`
* `python main.py`

___

#### Jacoco test coverage:

* `mvn clean test jacoco:report -Ptest`
* `target/site/jacoco/index.html`

___

#### Sonar analyze:

* `mvn clean install -Ptest`
* `mvn sonar:sonar`

___

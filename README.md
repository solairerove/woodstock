# Woodstock
[![Dependency Status](https://www.versioneye.com/user/projects/57e682d979806f002f4ab840/badge.svg?style=flat-square)](https://www.versioneye.com/user/projects/57e682d979806f002f4ab840)

*You should see [hrms](https://github.com/vlsidlyarevich/unity) module. There will be some integration in future.*
___

#### How to start:

* `docker-compose up`
* `mvn clean install && java -jar target/*.jar`
___

#### Jacoco test coverage:

* `mvn clean test jacoco:report`
* `target/site/jacoco/index.html`
___

#### Sonar analyze:

* `[settings.xml](https://goo.gl/4XsqqY)` - in .m2/
* `configure sonar`
* `mvn clean install`
* `mvn sonar:sonar`
___

#### Api doc:

* There will be some curl examples...
* Fuck this shit about documentation. Download *[Insomnia](https://insomnia.rest/download/#ubuntu)* and import *[woodstock.json](https://goo.gl/wZeKf1)*

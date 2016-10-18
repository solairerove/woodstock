# Woodstock
[![Dependency Status](https://www.versioneye.com/user/projects/57e682d979806f002f4ab840/badge.svg?style=flat-square)](https://www.versioneye.com/user/projects/57e682d979806f002f4ab840)

*You should see [hrms](https://github.com/vlsidlyarevich/unity) module. There will be some integration in future.*
___

#### How to start:

* `docker-compose up`
* `mvn spring-boot:run`
* `mvn clean install -DskipTests=true && jar -jar target/*.jar`
___

#### Jacoco test coverage:

* `mvn clean test jacoco:report`
* `target/site/jacoco/index.html`
___

#### Sonar analyze:

* [settings.xml](https://www.dropbox.com/s/d30qle3uocvf4mz/settings.xml?dl=0) - in .m2/
* `configure sonar`
* `mvn clean install`
* `mvn sonar:sonar`
___

#### Api doc:

* There will be some curl examples

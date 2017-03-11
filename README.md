# Woodstock

* You should see [hrms](https://github.com/vlsidlyarevich/unity) module. 
There will be some integration in future.
___

## Env:

``` bash
$ java -version
java version "1.8.0_111"
Java(TM) SE Runtime Environment (build 1.8.0_111-b14)
Java HotSpot(TM) 64-Bit Server VM (build 25.111-b14, mixed mode)

$ mvn -v
Apache Maven 3.3.9
Maven home: /opt/env/maven339
Java version: 1.8.0_111, vendor: Oracle Corporation
Java home: /opt/env/jdk8/jre
Default locale: en_US, platform encoding: UTF-8
OS name: "linux", version: "4.4.52-1-manjaro", arch: "amd64", family: "unix"

$ ng version
                             _                           _  _
  __ _  _ __    __ _  _   _ | |  __ _  _ __         ___ | |(_)
 / _` || '_ \  / _` || | | || | / _` || '__|_____  / __|| || |
| (_| || | | || (_| || |_| || || (_| || |  |_____|| (__ | || |
 \__,_||_| |_| \__, | \__,_||_| \__,_||_|          \___||_||_|
               |___/
angular-cli: 1.0.0-beta.28.3
node: 7.7.1
```

## Generate stub in mongo:

* `mvn clean install && java -jar -Dspring.profiles.active=generate *.jar`

## Start backend:

* `mvn clean install && java -jar *.jar`

## Start frontend:

* `ng serve`

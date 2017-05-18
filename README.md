# Woodstock (DEAD)

It's dead too. It's dead course work. 
___

## Env:

``` bash
✗ java -version
java version "1.8.0_121"
Java(TM) SE Runtime Environment (build 1.8.0_121-b13)
Java HotSpot(TM) 64-Bit Server VM (build 25.121-b13, mixed mode)

✗ mvn -v
Apache Maven 3.3.9 (bb52d8502b132ec0a5a3f4c09453c07478323dc5; 2015-11-10T19:41:47+03:00)
Maven home: /usr/local/Cellar/maven/3.3.9/libexec
Java version: 1.8.0_121, vendor: Oracle Corporation
Java home: /Library/Java/JavaVirtualMachines/jdk1.8.0_121.jdk/Contents/Home/jre
Default locale: en_US, platform encoding: UTF-8
OS name: "mac os x", version: "10.12.1", arch: "x86_64", family: "mac"

✗ create-react-app -V 
1.3.0

✗ node -v
v7.7.3

✗ npm -v
4.1.2
```

## Generate stub in mongo:

* `mvn clean install -T 4 && java -jar -Dspring.profiles.active=generate *.jar`

## Invoke tests:

* `mvn clean install -Ptest -T 4`

## Start backend:

* `mvn clean install -T 4 && java -jar *.jar`

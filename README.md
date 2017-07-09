# spring-boot-profiling
[![Clojars Project](https://img.shields.io/clojars/v/com.maystrovyy/spring-boot-profiling.svg)](https://clojars.org/com.maystrovyy/spring-boot-profiling)

## Motivation

I wanted to create this spring-boot extention because it's a simple and useful code if you need to measure execution 
time of the methods. If your task doesn't require large benchmarks - then this will suit you!
I enjoy programming in Clojure.

Besides, I wanted to:
* improve my skills in Clojure
* eventually find some time to do something open-source
* have a good time!

## Usage

Add this to your pom.xml:

```
<repository>
  <id>clojars.org</id>
  <url>http://clojars.org/repo</url>
</repository>
```
```
<dependency>
  <groupId>com.maystrovyy</groupId>
  <artifactId>spring-boot-profiling</artifactId>
  <version>0.0.4</version>
</dependency>
```

### Dependencies
Parent is spring-boot-1.5.4, so I advise you to remove duplicates, such as:
```
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-aop</artifactId>
</dependency>
<dependency>
  <groupId>org.projectlombok</groupId>
  <artifactId>lombok</artifactId>
</dependency>
```
Also, you can only source code and use it on any logging or aop framework.

## Output
As a result you'll see this:
```
2017-07-09 17:49:34.268  INFO 1441 --- [  restartedMain] com.maystrovyy.aspect.ProfilingAspect    : Profiling in class com.maystrovyy.HelloWorld method: sayHello started...
2017-07-09 17:50:24.242  INFO 1441 --- [  restartedMain] com.maystrovyy.aspect.ProfilingAspect    : Execution time in class com.maystrovyy.HelloWorld method: sayHello = n seconds.
```
or
```
2017-07-09 17:49:34.268  INFO 1441 --- [  restartedMain] com.maystrovyy.aspect.ProfilingAspect    : Profiling in class com.maystrovyy.HelloWorld method: sayHello started...
2017-07-09 17:50:24.242  INFO 1441 --- [  restartedMain] com.maystrovyy.aspect.ProfilingAspect    : Execution time in class com.maystrovyy.HelloWorld method: sayHello = n milliseconds.
```
If the method was executed less than 10 seconds - the calculation will be in milliseconds, in all other cases - in seconds.

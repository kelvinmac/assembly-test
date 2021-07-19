# assembly-test
This is a scala project using `sbt-assembly` to create a fat jar. However, there seems to be a bug or misconfiguration since the class in `app` project do no appear in the final jar.

# Building project

To build the project, I run the following command:
```
sbt assembly
```

This will produce a `assembly-test-assembly-0.1.jar` in the `target/scala-2.13`. While in that directory, we can run this jar using the command:
```
java -jar assembly-test-assembly-0.1.jar 
```

Running this command results in the following error:
```java
Error: Could not find or load main class com.kelvin.assembly.Main
Caused by: java.lang.ClassNotFoundException: com.kelvin.assembly.Main
```

We can run the following command to see the classes in the generated jar, and we can see that the class in project `app` really isn't in the jar (see [Classes.txt](classes.txt))
```
jar tf assembly-test-assembly-0.1.jar > classes.txt
```

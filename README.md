human-readable-ids-java
=======================

A Java id generator to produce random human-readable identifiers like 'fast-elephant-42'

Maven
-----
```xml
<dependency>
    <groupId>com.github.kkuegler</groupId>
    <artifactId>human-readable-ids-java</artifactId>
    <version>0.2</version>
</dependency>
``` 

Use
---
```java
// create the generator once and use it any number of times, even concurrently across threads
HumanReadableIdGenerator idGen = new PermutationBasedHumanReadableIdGenerator();
String id = idGen.generate();
```

Acknowledgments
---------------
This project is based on the idea and word lists of [human-readable-ids.js](https://git.coolaj86.com/coolaj86/human-readable-ids.js)

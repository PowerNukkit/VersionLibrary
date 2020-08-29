Version Library
---------------
A simple library that implement a smart version comparision, accepting various version formats.

### Adding to your project

#### Maven
Just add it as dependency in your **pom.xml**

```xml
<dependencies>
    <dependency>
        <group>org.powernukkit</group>
        <artifact>version-library</artifact>
        <version>0.1.0-SNAPSHOT</version>
    </dependency>
</dependencies>
```

To use the latest snapshot  add the sonatype snapshot repository to your pom.xml

```xml
<repositories>
    <repository>
        <id>powernukkit-snapshots</id>
        <url>https://oss.sonatype.org/content/repositories/snapshots</url>
    </repository>
</repositories>
```

#### Gradle

Just add it as dependency in your **build.gradle** file

```groovy
dependencies {
    implementation 'org.powernukkit:version-library:0.1.0-SNAPSHOT'
}
```

Also make sure to add maven central or jcenter to your repositories if you don't have them
```groovy
repositories {
    mavenCentral()
}
```

### Examples
```java
List<String> list = new ArrayList<>(Arrays.asList(
        "1","4","2.2","32.1","1.1","1.2","1.1.0.1-beta","b","a","z","K", "1.2-beta"
));
list.sort(VersionStringComparator.getInstance());
assertEquals(Arrays.asList(
        "a","b","K","z","1","1.1","1.1.0.1-beta","1.2-beta","1.2","2.2","4","32.1"
), list);
```

```java
// 1.1 < 1.1.1
assertEquals(-1, new Version("1.1").compareTo(new Version("1.1.1")));

// 1.1.1-BETA < 1.1.1
assertEquals(1, new Version("1.1.1").compareTo(new Version("1.1.1-BETA")));

// alpha1 < beta2
assertEquals(-1, new Version("alpha1").compareTo(new Version("beta2")));
```

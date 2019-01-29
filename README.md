# AvroReflectedExample
Simple example of creating an Avro schema from a class.

Example will create an Avro schema and Avro object from a class using a rock climbing facility as the entity.

This is a Java/Maven project using JDK1.8.

**Simple steps for a simple example:**
- Using reflection to create an Avro schema (.avsc file) from a class (Class -> Reflection -> Avro Schema)
- Then use reflection to create an Avro object (.avro file) from the same class (Class -> Reflection -> Avro Object)

**Reading your Avro object using tools**
```commandline
$ wget http://central.maven.org/maven2/org/apache/avro/avro-tools/1.8.2/avro-tools-1.8.2.jar
$ java -jar avro-tools-1.8.2.jar tojson --pretty climbinggym.avro
```

**Other examples**
<br/>
Generic Record
<br/>
https://github.com/scottsappen/AvroGenericExample
<br/>

Specific Record
<br/>
https://github.com/scottsappen/AvroSpecificExample

Schema evolution with a Java producer and consumer and Confluent Schema Registry
<br/>
https://github.com/scottsappen/AvroProdConsExample

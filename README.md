STL Parser
----------
STL Parser for ASCII files, reads in an STL file and reports the number of triangles contained in the file and the surface area of the model.


Design Considerations
---------------------
 
 I assumed that the input STL files are all properly formed and when parsing the file just look for vertices in order to identify triangles. In order to have a more robust solution and by understanding all possible tokens a STL file can have and the link between them would allow a more rigourous check/validation of the input files and a better error handling for the user, if needed.
 My first implementation to read the contents of a file was using [Scanner](https://docs.oracle.com/javase/8/docs/api/java/util/Scanner.html) which is very simple to manipulate. It does have a small buffer (1K) to traverse the file but it requires loading the whole file in memory. [BufferedReader](https://docs.oracle.com/javase/8/docs/api/java/io/BufferedReader.html) on the other hand reads the file in chunks of 8K (default).
 After comparing both techniques, [BufferedReader] presented a 50% better performance than Scanner.


Pre-requisites
--------------
 This is a Java Maven project and requires the following to build:
  * [Java 1.8+](https://www.oracle.com/java/technologies/javase/javase-jdk8-downloads.html)
  * [Maven](https://maven.apache.org/)
 
 *To execute, only a JRE is required.*

Build
-----
 To build this project, just execute:
```
mvn package
```
 
 The command above will run all the unit tests/packaging tasks and will generate a JAR file in this location: 
```
./target/stl-parser.jar
```
 aaa

Usage
-----
 To run stl-parser, execute the following command:
```
java -jar target/stl-parser.jar <path/to/stl-file>
```

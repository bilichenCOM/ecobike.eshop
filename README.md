#*EcoBike e-shop*
##command line prototype
<p>This is implementation of a prototype for e-shop of EcoBike company.</p>
<p>It is completely command line application, that supports now seven operations:</p>
<ul>
    <li>
        Show the entire EcoBike catalog
    </li>
    <li>
        Add new folding bike
    </li>
    <li>
        Add new speedelec
    </li>
    <li>
        Add new e-bike
    </li>
    <li>
        Find the first item of a particular brand
    </li>
    <li>
        Write to file
    </li>
    <li>
        Stop the program
    </li>
</ul>
All items which were added through 'Add new ...' command will be saved in<br/>
temporary memory and if not written to file, they will disappear after stopping<br/>
the program. To save items for durable period of time use 'Write to file' command -<br/>
it will write all new items using special format to external plain-text file, that<br/>
can be used as input later.

##start application
To start application you should download this source code and using maven<br/>
you can compile and package this project into single executable jar-file.<br/>
Just invoke ```mvn clean package``` in project root.<br/>
After compiling and assembling process is done. You can run it using your console<br/>
```java -jar target/ecobike-eshop-prototype-jar-with-dependencies.jar```<br/>
(jre version 1.8 and higher is required)<br/>
##input params
This application works with data provided in plain-text files.<br/>
Paths to these files can be specified on startup through command line parameters.<br/>
Example:<br/>
`java -jar target/ecobike-eshop-prototype-jar-with-dependencies.jar --input=ecobike.txt --ouput=output.txt`<br/>
(here are default values)<br/>
If no params were provided on startup default values remain:<br/>
 `ecobike.txt` - for input<br/>
 `output.txt` - for output

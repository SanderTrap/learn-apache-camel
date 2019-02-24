# Simple Camel Route
This project is part of a Udemy course called [Apache Camel for Beginners - Learn by Coding in Java](https://www.udemy.com/apache-camel-for-beginners-learn-by-coding-in-java/)

This project is meant to learn how to create a simple Apache Camel route.

## Files
* `CopyFilesCamel`: will copy `input/file1.txt` and `input/file2.txt`  in the `data` folder to the `data/output` folder.

* `CopyFilesCamelLogging`: will copy `input/file1.txt` and `input/file2.txt`  in the `data` folder to the `data/output` folder.
Logs are added to the console showing the headers and body of the `Exchange` object.

* `CopyFilesCamelMultiRoute`: will copy `input/file1.txt` and `input/file2.txt`  in the `data` folder to the `data/output` folder.
The same files are also copied to `data/another-file` folder.
In addition to that it has another Camel route that will copy `input1/file3.txt` and `input1/file4.txt`  in the `data` folder to the `data/output1` folder.

* `CopyFilesWithoutCamel`: does the same as `CopyFilesCamel` but with plain Java (without Apache Camel).
@echo off
cd C:\Users\khattabm\git\FullFramework
mvn clean test -PHeadlessSuite
cd test-output
start index.html
pause
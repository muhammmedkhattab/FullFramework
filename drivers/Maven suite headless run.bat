@echo off
cd C:\Users\khattabm\eclipse-workspace\FrameWork
mvn clean test -PHeadlessSuite
cd test-output
start index.html
pause
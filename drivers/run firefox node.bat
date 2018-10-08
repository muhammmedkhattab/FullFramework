@echo off
cd C:\Users\khattabm\eclipse-workspace\FrameWork\grid
java -jar -Dwebdriver.gecko.driver="C:\Users\khattabm\eclipse-workspace\FrameWork\drivers\geckodriver.exe"   selenium-server-standalone.jar -role webdriver -hub http://localhost:4444/grid/register -port 5556 -browser browserName=firefox,maxInstances=10


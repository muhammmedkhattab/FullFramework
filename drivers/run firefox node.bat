@echo off
cd C:\Users\khattabm\eclipse-workspace\FrameWork\grid
java -jar -Dwebdriver.firefox.driver="C:\Users\khattabm\eclipse-workspace\FrameWork\drivers\geckodriver.exe" selenium-server-standalone.jar -role node -hub http://localhost:4444/grid/register -browser browserName=firefox,maxInstances=10 -port 5556


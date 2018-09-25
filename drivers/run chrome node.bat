@echo off
cd C:\Users\khattabm\eclipse-workspace\FrameWork\grid
java -jar -Dwebdriver.chrome.driver="C:\Users\khattabm\eclipse-workspace\FrameWork\drivers\chromedriver.exe" selenium-server-standalone.jar -role node -hub http://localhost:4444/grid/register -browser browserName=chrome,maxInstances=10 -port 5557
pause
@echo off
cd C:\Users\khattabm\git\FullFramework
java -jar -Dwebdriver.chrome.driver="CC:\Users\khattabm\git\FullFramework\drivers\chromedriver.exe" selenium-server-standalone.jar -role node -hub http://localhost:4444/grid/register -browser browserName=chrome,maxInstances=10 -port 5557
pause
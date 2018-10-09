@echo off
cd C:\Users\khattabm\git\FullFramework\grid
java -jar -Dwebdriver.ie.driver=C:\Users\khattabm\git\FullFramework\drivers\IEDriverServer.exe -jar selenium-server-standalone.jar -port 5595 -role node -hub http://localhost:4444/grid/register -browser “browserName=internet explorer,version=11,platform=WINDOWS,maxInstances=10”
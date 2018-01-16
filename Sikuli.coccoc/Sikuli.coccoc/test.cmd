::Copy result to server
set name=%DATE:/=_%
set name=%name: =_%
set extentFile=%TIME::=-%
set extentFile=%extentFile:.=-%
mkdir \\10.0.12.110\share\saviorResult\%name%\
%systemroot%\System32\xcopy "src\main\resources\saviorTop55\SaviorTracking.xls" \\10.0.12.110\share\saviorResult\%name%\SaviorTracking_%extentFile%.xls*
%systemroot%\System32\xcopy "src\main\resources\saviorTop55\SaviorTracking.xls" .

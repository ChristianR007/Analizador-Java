SET JAVA_HOME="C:\Program Files\Java\jdk1.8.0_73\bin"
SET PATH=%JAVA_HOME%;%PATH%
SET CLASSPATH=%JAVA_HOME%;
cd C:\Users\Christian\Documents\NetBeansProjects\COMPI2\src\Analizador
java -jar C:\Users\Christian\Desktop\usac\librerias\java-cup-11b.jar -parser Analizador_Sintactico -symbols Simboloss A_Sintactico.cup
pause

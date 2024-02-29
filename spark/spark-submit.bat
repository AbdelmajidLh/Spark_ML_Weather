@echo off

set SPARK_HOME=D:\BigData_tools\spark-3.5.0
set SPARK_MASTER=local[*]
set APP_JAR=C:\Users\abdel\IdeaProjects\Spark_ML_Weather\target\Spark_ML-1.0-SNAPSHOT.jar
set APP_MAIN_CLASS=org.example.Main

"%SPARK_HOME%\bin\spark-submit" ^
  --master %SPARK_MASTER% ^
  --class %APP_MAIN_CLASS% ^
  %APP_JAR%

#!/bin/bash

# Chemin vers le répertoire de votre application
APP_DIR="C:/Users/abdel/IdeaProjects/Spark_scala3/target"
JAR_FILE="Spark_scala3-1.0-SNAPSHOT.jar"
JAR_PATH="$APP_DIR/$JAR_FILE"
PROPERTIES_FILE="$APP_DIR/spark_submit.properties"

# Exécution de spark-submit avec les propriétés
$SPARK_HOME/bin/spark-submit \
  --properties-file $PROPERTIES_FILE \
  --class org.example.App \
  --master local[*] $JAR_PATH

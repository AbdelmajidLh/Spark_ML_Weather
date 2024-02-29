# Spark Scala 3 in Practice

Ce projet est un exemple simple d'application Spark Scala 3 pour le traitement de données.

## Structure du Projet

- **src/main/scala:** Contient le code source Scala.
- **data/:** Fichiers de données
- **shell/:** Scripts bash pour la création d'arborescence Hadoop
- **spark/:** Scripts spark-submit et les fichiers properties.
- **pom.xml:** Fichier de configuration Maven.

## Inspiration

Ce projet a été inspiré par le livre "Spark: The Definitive Guide". Nous avons adapté les concepts du livre pour illustrer une application Spark Scala 3 pratique.

## Configuration de l'Environnement de Développement

Pour développer localement, assurez-vous d'avoir les outils suivants installés sur votre machine :

- [Java](https://www.oracle.com/java/technologies/javase-downloads.html)
- [Scala](https://www.scala-lang.org/download/)
- [Apache Maven](https://maven.apache.org/download.cgi)
- [Apache Spark](https://spark.apache.org/downloads.html)

## Construction et Exécution

1. Clonez le projet :
   ```bash
   git clone https://github.com/AbdelmajidLh/Spark_scala3.git
   ```

2. Naviguez dans le répertoire du projet :
   ```bash
   cd Spark_scala3
   ```

3. Compilez et exécutez le projet :
   ```bash
   mvn compile exec:java
   ```

## Lancer le traitement spark
   ```bash
   mvn compile exec:java
   ```

## Suivre le job sur le cluster manager
[local host](http://localhost:4040/jobs/)

## Auteur

Abdelmajid EL HOU - Data Scientist & Ingénieur, PhD

## Licence

Ce projet est sous licence [MIT License](LICENSE).
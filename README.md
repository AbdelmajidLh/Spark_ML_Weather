# ML_Spark_Weather

Ce projet utilise Apache Spark et Scala pour prédire si il va pleuvoir demain en se basant sur les données météorologiques historiques.

## Prérequis

Avant de commencer, assurez-vous d'avoir les éléments suivants installés :

- Apache Spark
- Scala
- Java
- Maven

## Installation

1. Clonez ce dépôt :

```bash
git clone https://github.com/AbdelmajidLh/ML_Spark_Weather.git
```

2. Accédez au répertoire du projet :

```bash
cd ML_Spark_Weather
```

3. Compilez le projet avec Maven : ou via votre IntelliJ (package) pour générer le jar.

```bash
mvn clean package
```

## Utilisation

1. Assurez-vous d'avoir un fichier CSV contenant les données météorologiques. Vous pouvez utiliser le fichier `weatherAUS.csv` fourni dans le répertoire `data`. Si vous utilisez un autre fichier, assurez-vous qu'il est bien formaté selon le schéma attendu.

2. Modifiez le chemin du fichier CSV dans le fichier Main.scala si nécessaire :

```scala
val filePath = "data/weatherAUS.csv"
```

3. Exécutez le programme en utilisant la commande suivante dans Windows (version unix sera ajoutée):

```bash
# assurer d'avoir la bonne configuration dans ce fichier qui se trouve dans spark/
spark-submit.bat
```

## Contributions

Les contributions sont les bienvenues ! N'hésitez pas à ouvrir une nouvelle issue ou à soumettre une pull request.

## Licence

Ce projet est sous licence [MIT](https://opensource.org/licenses/MIT).
```
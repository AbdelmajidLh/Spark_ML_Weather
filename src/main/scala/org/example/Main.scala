package org.example

import org.apache.spark.sql.SparkSession
import org.apache.spark.ml.classification.LogisticRegression
import org.apache.spark.ml.evaluation.BinaryClassificationEvaluator
import org.example.dataloader.DataLoader
import org.example.featureengineering.FeatureEngineering

object Main {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder()
      .appName("Spark ML predict Weather")
      .config("spark.sql.warehouse.dir", "D:/BigData_tools/spark-3.5.0/warehouse")
      .getOrCreate()

    val dataLoader = new DataLoader(spark)
    val featureEngineering = new FeatureEngineering(spark)

    // Spécifier le chemin absolu du fichier CSV sur votre système local
    val filePath = "C:/Users/abdel/IdeaProjects/data/weatherAUS.csv"
    println(s"Chemin du fichier : $filePath")

    // Charger les données depuis le fichier CSV
    val AusDF = dataLoader.loadData(filePath)
    AusDF.show()

    // Effectuer l'ingénierie des fonctionnalités
    val processedData = featureEngineering.prepareFeatures(AusDF)
    processedData.show()

    // Diviser les données en ensembles d'entraînement et de test
    val Array(train, test) = processedData.randomSplit(Array(0.7, 0.3))

    // Entraîner le modèle de régression logistique
    val lr = new LogisticRegression()
      .setLabelCol("label")
      .setFeaturesCol("features")
      .setMaxIter(10)
      .setRegParam(0.3)

    val model = lr.fit(train)

    // Faire des prédictions sur l'ensemble de test
    val prediction = model.transform(test)
    prediction.show()

    // Évaluer les performances du modèle
    val evaluator = new BinaryClassificationEvaluator()
      .setLabelCol("label")
      .setRawPredictionCol("rawPrediction")
      .setMetricName("areaUnderROC")

    val auc = evaluator.evaluate(prediction)
    println("AUC = " + auc)

    // Calculer d'autres métriques d'évaluation
    val tp = prediction.filter("prediction == 1 AND label == 1").count().toFloat
    val fp = prediction.filter("prediction == 1 AND label == 0").count().toFloat
    val tn = prediction.filter("prediction == 0 AND label == 0").count().toFloat
    val fn = prediction.filter("prediction == 0 AND label == 1").count().toFloat

    val metrics = spark.createDataFrame(Seq(
      ("TP", tp),
      ("FP", fp),
      ("TN", tn),
      ("FN", fn),
      ("Precision", tp / (tp + fp)),
      ("Recall", tp / (tp + fn))
    )).toDF("metric", "value")

    metrics.show()

    // Arrêter la session Spark
    spark.stop()
  }
}

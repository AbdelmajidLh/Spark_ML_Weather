package org.example.featureengineering

import org.apache.spark.ml.feature.{StringIndexer, VectorAssembler}
import org.apache.spark.sql.{DataFrame, SparkSession}
import org.apache.spark.ml.Pipeline
import org.apache.spark.sql.functions._
import org.apache.spark.sql.expressions._

class FeatureEngineering(spark: SparkSession) {
  def prepareFeatures(df: DataFrame): DataFrame = {
    import spark.implicits._ // Import des implicites Spark pour $ et autres

    // Définition des colonnes de fonctionnalités de type chaîne
    val StringfeatureCol = Array("Dates", "Location", "Evaporation", "Sunshine", "WindGustDir", "WindDir9am", "WindDir3pm", "RainToday", "RainTomorrow")

    // convertir les valeurs catégorielles en valeurs numériques pour être utilisées dans les modèles de machine learning
    val indexers = StringfeatureCol.map { colName =>
      new StringIndexer().setInputCol(colName).setHandleInvalid("skip").setOutputCol(colName + "_indexed")
    }

    val pipeline = new Pipeline().setStages(indexers)
    val indexedDF = pipeline.fit(df).transform(df)

    val assembler = new VectorAssembler()
      .setInputCols(Array("Dates_indexed", "Location_indexed", "MinTemp", "MaxTemp", "Rainfall", "Evaporation_indexed", "Sunshine_indexed", "WindGustDir_indexed", "WindGustSpeed", "WindDir9am_indexed", "WindDir3pm_indexed", "WindSpeed9am", "WindSpeed3pm", "Humidity9am", "Humidity3pm", "Pressure9am", "Pressure3pm", "Cloud9am", "Cloud3pm", "Temp9am", "Temp3pm", "RainToday_indexed", "RISK_MM"))
      .setOutputCol("features")

    // Sélection des colonnes d'intérêt
    assembler.transform(indexedDF).select($"features", $"RainTomorrow_indexed".alias("label"))
  }
}

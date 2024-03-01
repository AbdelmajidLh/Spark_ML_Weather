package org.example.dataloader

import org.apache.spark.sql.{DataFrame, Encoders, SparkSession}

// préciser le schema de données via une case class
case class Aus(Dates: String,
               Location: String,
               MinTemp: Double,
               MaxTemp: Double,
               Rainfall: Double,
               Evaporation: String,
               Sunshine: String,
               WindGustDir: String,
               WindGustSpeed: Integer,
               WindDir9am: String,
               WindDir3pm: String,
               WindSpeed9am: Integer,
               WindSpeed3pm: Integer,
               Humidity9am: Integer,
               Humidity3pm: Integer,
               Pressure9am: Double,
               Pressure3pm: Double,
               Cloud9am: Integer,
               Cloud3pm: Integer,
               Temp9am: Double,
               Temp3pm: Double,
               RainToday: String,
               RISK_MM: Double,
               RainTomorrow: String)

class DataLoader(spark: SparkSession) {
  def loadData(filePath: String): DataFrame = {
    // Chargement du fichier CSV à partir du chemin spécifié
    val csvPath = filePath
    val AusSchema = Encoders.product[Aus].schema

    // Lecture du fichier CSV en utilisant le schéma défini pour le DataFrame
    spark.read.schema(AusSchema).option("header", "true").csv(csvPath).na.fill(0)
  }
}

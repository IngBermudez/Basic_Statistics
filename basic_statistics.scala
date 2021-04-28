//correlation

//Empezamos con esta libreria para tener acceso a matrices locales y Métodos de fábrica para Vector.
import org.apache.spark.ml.linalg.{Matrix, Vectors}
//libreria para usar el metodo de correlacion
import org.apache.spark.ml.stat.Correlation
//permite acceder a un valor de una fila a través del acceso genérico por ordinal,  así como el acceso primitivo
import org.apache.spark.sql.Row

//Crea vectores densos y dispersos  a partir de sus valores, dentro de la matriz 
val data = Seq(
   (4, Seq((0, 1.0), (3, -2.0))),
  Vectors.dense(4.0, 5.0, 0.0, 3.0),
  Vectors.dense(6.0, 7.0, 0.0, 8.0),
  Vectors.sparse(4, Seq((0, 9.0), (3, 1.0)))
)

//Se extraen los datos de nuestra matriz y se crea un dataframe respecto a las caracteristicas 
val df = data.map(Tuple1.apply).toDF("features")
//Se crea la matriz de correlacion Pearson usando el dataframe que acabamos de crear y le pedimos los primeros valores con head
val Row(coeff1: Matrix) = Correlation.corr(df, "features").head
//imprimimos el resultado
println(s"Pearson correlation matrix:\n $coeff1")
//Se crea la matriz de correlacion Spearman usando el dataframe que acabamos de crear y le pedimos los primeros valores con head
val Row(coeff2: Matrix) = Correlation.corr(df, "features", "spearman").head
//imprimimos el resultado
println(s"Spearman correlation matrix:\n $coeff2")



//Hypothesis testing
import org.apache.spark.ml.linalg.{Vector, Vectors}
import org.apache.spark.ml.stat.ChiSquareTest

val data = Seq(
  (0.0, Vectors.dense(0.5, 10.0)),
  (0.0, Vectors.dense(1.5, 20.0)),
  (1.0, Vectors.dense(1.5, 30.0)),
  (0.0, Vectors.dense(3.5, 30.0)),
  (0.0, Vectors.dense(3.5, 40.0)),
  (1.0, Vectors.dense(3.5, 40.0))
)

val df = data.toDF("label", "features")
val chi = ChiSquareTest.test(df, "features", "label").head
println(s"pValues = ${chi.getAs[Vector](0)}")
println(s"degreesOfFreedom ${chi.getSeq[Int](1).mkString("[", ",", "]")}")
println(s"statistics ${chi.getAs[Vector](2)}")


//Summarizer
import org.apache.spark.ml.linalg.{Vector, Vectors}
import org.apache.spark.ml.stat.Summarizer

val data = Seq(
  (Vectors.dense(2.0, 3.0, 5.0), 1.0),
  (Vectors.dense(4.0, 6.0, 7.0), 2.0)
)

val df = data.toDF("features", "weight")

val (meanVal, varianceVal) = df.select(metrics("mean", "variance").summary($"features", $"weight").as("summary")).select("summary.mean", "summary.variance").as[(Vector, Vector)].first()

println(s"with weight: mean = ${meanVal}, variance = ${varianceVal}")

val (meanVal2, varianceVal2) = df.select(mean($"features"), variance($"features"))
  .as[(Vector, Vector)].first()

println(s"without weight: mean = ${meanVal2}, sum = ${varianceVal2}")
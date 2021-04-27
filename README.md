# Basic_Statistics

## Correlation(Correlacion) 

Calcular la correlación entre dos series de datos es una operación común en Estadística. En spark ofrecen la flexibilidad de calcular correlaciones por pares entre muchas series. Los métodos de correlación admitidos son actualmente la correlación de Pearson y Spearman.

### 1. Que es una correlacion?
Es cuando dos variables están asociadas cuando una variable nos da información acerca de la otra.

### 2. Como interpretar Una correlacion

El signo nos indica la dirección de la relación, como hemos visto en el diagrama de dispersión.

- un valor positivo indica una relación directa o positiva,
- un valor negativo indica relación indirecta, inversa o negativa,
- un valor nulo indica que no existe una tendencia entre ambas variables (puede ocurrir que no exista relación o que la relación sea más compleja que una tendencia)

La magnitud nos indica la fuerza de la relación, y toma valores entre -1 a 1. Cuanto más cercano sea el valor a los extremos del intervalo (1 o -1) más fuerte será la tendencia de las variables, o será menor la dispersión que existe en los puntos alrededor de dicha tendencia. Cuanto más cerca del cero esté el coeficiente de correlación, más débil será la tendencia, es decir, habrá más dispersión en la nube de puntos.
- si la correlación vale 1 o -1 diremos que la correlación es “perfecta”,
- si la correlación vale 0 diremos que las variables no están correlacionadas.

### 3. Correlacion en scala
La correlación calcula la matriz de correlación para el conjunto de datos de vectores de entrada utilizando el método especificado. La salida será un DataFrame que contiene la matriz de correlación de la columna de vectores.

### Video explicativo
>https://www.youtube.com/watch?v=wJSy_6jkO1w


## Hypothesis testing (Evaluación de la hipótesis)
La prueba de hipótesis es una herramienta poderosa en estadística para determinar si un resultado es estadísticamente significativo, si este resultado ocurrió por casualidad o no. spark.ml actualmente admite las pruebas de independencia de chi-cuadrado (χ2) de Pearson.

###  ¿Que es una hipótesis?
Una hipótesis es la suposición de algo que podría, o no, ser posible. En este sentido, la hipótesis es una idea o un supuesto a partir del cual nos preguntamos el porqué de una cosa, bien sea un fenómeno, un hecho o un proceso.

### ¿Qué es el estadístico de chi-cuadrada?
Probar la independencia o determinar la asociación entre variables categóricas. Por ejemplo, si usted tiene una tabla de dos factores de resultados electorales basada en el sexo de los votantes, los estadísticos de chi-cuadrada pueden ayudar a determinar si un voto es independiente del sexo del votante o si existe alguna asociación entre voto y sexo. Si el valor p asociado con el estadístico de chi-cuadrada es menor que el nivel de significancia (α) seleccionado, la prueba rechaza la hipótesis nula de que las dos variables son independientes.

### Interpretación
El estadístico chi-cuadrado tomará un valor igual a 0 si existe concordancia perfecta entre las frecuencias observadas y las esperadas; por contra, el estadístico tomará un valor grande si existe una gran discrepancia entre estas frecuencias, y consecuentemente se deberá rechazar la hipótesis nula.

### En Scala
En scala se hace uso de un dataframe el cual puede ser a partir de vectores, para posteriormente elegir las columnas o variables deseadas para realizar la prueba de Chi-cuadrada mediante funciones internas en el lenguaje.

### Video explicativo
https://www.youtube.com/watch?v=gHkMGcn2MsE



## Summarizer(Resumidor)

Proporcionamos estadísticas de resumen de columnas vectoriales para Dataframe a través de Summarizer. Las métricas disponibles son el máximo, el mínimo, la media, la varianza y el número de no ceros en columnas, así como el recuento total.

El método Summarizer es una buena herramienta para obtener varias estadísticas en una nueva columna de vector cuando se utilizan canalizaciones de aprendizaje automático. Para usar el Summarizer, importe el paquete de pyspark.ml.stat import Summarizer en PySpark e importe org.apache.spark.ml.stat Summarizer en Spark Scala.
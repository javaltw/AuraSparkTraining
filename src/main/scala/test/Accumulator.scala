package test

import org.apache.spark.{SparkConf, SparkContext}

object Accumulator {
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setAppName("Accumulator").setMaster("local[*]")
    val sc = new SparkContext(sparkConf);
    sc.setLogLevel("warn")
    val sum = sc.longAccumulator("accumulator")

    //累加器写在action操作中
    //    val rdd = sc.makeRDD(Array(1, 3, 2, 4))
    //    rdd.foreach(
    //      x=> sum.add(x)
    //    )

    //累加器写在转换操作中,在没有缓存的情况下，有Action算子会触发多次累加器操作
    val errorRdd = sc.parallelize(1 to 10).map(x => {
      sum.add(1)
      x
    })
    // 把rdd加入缓存当中
    errorRdd.cache()
//    errorRdd.persist()
    errorRdd.count()
    println("sum1=" + sum.value)
    errorRdd.reduce(_ + _)
    println("sum2=" + sum.value)

  }

}

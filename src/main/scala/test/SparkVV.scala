package test

import org.apache.spark.{SparkConf, SparkContext}

object SparkVV {
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setAppName("SparkVV").setMaster("local[1]")
    val sc = new SparkContext(sparkConf)
    sc.setLogLevel("warn")

    val rdd1 = sc.parallelize(1 to 5)
    val rdd2 = sc.parallelize(5 to 9)

    //union()
//        rdd1.union(rdd2).collect().foreach(println(_))


    //subtract()
//        rdd1.subtract(rdd2).collect().foreach(println)
//        rdd2.subtract(rdd1).collect().foreach(println)

    //intersection()
//        val rdd3=rdd1.intersection(rdd2).foreach(println)

    //cartesian()
//          rdd1.cartesian(rdd2).foreach(print)

    println("------------------------------------------------------")
    println(" rdd1的分区数目： " + rdd1.getNumPartitions)
    println(" rdd2的分区数目： " + rdd2.getNumPartitions)

    println("------------------------------------------------------")
    //zip()
//    rdd1.zip(rdd2).foreach(println)
    //    println("zip2 :"+rdd2.zip(rdd1).foreach(println))
    //    println("zip2 :"+rdd2.zip(rdd2).foreach(println))


  }

}

package test

import org.apache.spark.{SparkConf, SparkContext}

object SparkV {
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("SparkV")
    val sc = new SparkContext(sparkConf)
    sc.setLogLevel("warn")

    val rdd = sc.parallelize(1 to 10)

    //sample()
//    println("------------")
//    rdd.sample(false,0.4,2).foreach(println)
//    println("------------")
//    rdd.sample(true,0.4,2).foreach(println)

    val dataList = List(("female", 1), ("female", 3), ("male", 5), ("female", 5), ("male", 2))
    val dataArray = Array("tom", "tom", "tom", "cat", "cat", "hello", "word")
    val wordAndNumRdd = sc.parallelize(dataList, 2)
    val wordRdd = sc.parallelize(dataArray,3)

    //   reduceByKey()
//        val rdd1 = wordAndNumRdd.reduceByKey(_ + _)
//        println("--------------------------reduceByKey()--------------------------")
//        rdd1.collect().foreach(print)
//        println(rdd1.getNumPartitions)

    //    groupByKey()
    //    val rdd2 = wordRdd.map(x => (x, 1))
    //    val res2 = rdd2.groupByKey().map(x => (x._1, x._2.sum))
    //    res2.foreach(print)

    //    aggregateByKey()
//        val rdd3 = wordAndNumRdd.aggregateByKey(0)(_ + _, _ + _)
//        rdd3.foreach(println)

//        val rdd4 = wordAndNumRdd.aggregateByKey(0)(math.max(_,_), _ + _)
//        rdd4.foreach(println)

    //    combineByKey  求出每个RDD的和，次数，均值
    //    val comRdd = wordAndNumRdd.combineByKey(
    //      (_, 1),
    //      (U: (Int, Int), V) => (U._1 + V, U._2 + 1),
    //      ((U1: (Int, Int), U2: (Int, Int)) => (U1._1 + U2._1, U2._1 + U2._2))
    //    )
    //    comRdd.foreach(print)
    //    //取出每个RDD的均值=RDD的VALUE/相同KEY的个数
    //    comRdd.mapValues(x => x._1 / x._2.toDouble).foreach(print)

    //    sortByKey默认true升序，手动设置false可改为降序
//    val sortRdd = sc.parallelize(Array((3, "aa"), (6, "cc"), (2, "bb"), (1, "dd")))
//    sortRdd.sortByKey().collect().foreach(print)
//    println("------------------------")
//    sortRdd.mapValues(_+"data").foreach(print)

  }

}

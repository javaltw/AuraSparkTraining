package test

import org.apache.spark.{SparkConf, SparkContext}

object sparkWordcount {
  def main(args: Array[String]): Unit = {

//        val sparkSession = SparkSession
//          .builder()
//          .master("local[*]")
//          .appName("SparkCount")
//          //.enableHiveSupport() //支持hive
//          .getOrCreate()
//        val sc = sparkSession.sparkContext

    val sparkConf = new SparkConf()
      .setMaster("local[*]")
      .setAppName("SparkCount");
    val sc = new SparkContext(sparkConf);
    sc.setLogLevel("warn")

    val wordRDD = sc.textFile("README.md").flatMap(_.split(" ")).map((_, 1));

    //把相同的key对应的value相加
    //方法一
    //    val res = wordRDD.wordRDDreduceByKey(_ + _)
    //方法二
    //    val res = wordRDD.groupByKey().map(x => (x._1, x._2.sum))
    //方法三
//        val res =wordRDD.aggregateByKey(0)(_+_,_+_)
    //方法四
    val res = wordRDD.foldByKey(0)(_ + _)
//    res.foreach(println)


    //词频降序排序
    //方法一
    val resRdd = res.sortBy(_._2, false)
    //方法二
    // val resRdd= res.map(x=>( x._2,x._1)).sortByKey(false).map(x=>( x._2,x._1))

    resRdd.foreach(println)
//    resRdd.saveAsTextFile("data/outPut")


//    val wordRDD2 = sc.textFile("D:\\IDcode\\ScalaTest\\derby.log");
//    wordRDD2.flatMap(_.split(" ")).map((_, 1)).reduceByKey(_ + _).foreach(println)

    sc.stop()


  }
}

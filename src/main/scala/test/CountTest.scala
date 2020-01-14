package test

import org.apache.spark.{SparkConf, SparkContext}


object CountTest {
  def main(args: Array[String]): Unit = {
    val sparkConf=new SparkConf().setAppName("CountTest")
    val sc=new SparkContext(sparkConf)

    val rdd=sc.textFile("data/textfile/Hamlet.txt").flatMap(_.split(' ')).map(x=>(x,1))
    rdd.reduceByKey(_+_).sortBy(_._2,false).take(10).foreach(println)
//      .saveAsTextFile(" data/output" )
//    .collect().foreach(println)

    sc.stop()


  }

}

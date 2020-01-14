package test

import org.apache.spark.{SparkConf, SparkContext}

object SparkAction {
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("SparkAction")
    val sc = new SparkContext(sparkConf)


        val numRdd= sc.parallelize(Array(1,11,3,5,7,9))
        val rakeNum=numRdd.take(3)
        val orderNum=numRdd.takeOrdered(4).foreach(println)

    //aggregate()
//    val numRdd2 = sc.makeRDD(1 to 10, 2)
//    val num = 0
    //    var num= numRdd2.aggregate(1)(_+_,_+_)
    //fold()
    //    val num=numRdd2.fold(1)(_+_)
    //count()
    //    val num= numRdd2.count()
    //reduce()
//    println("---------------" + numRdd2.reduce(_ + _))


    //    println("num="+num)


    sc.stop()
  }

}

package test

import org.apache.spark.{HashPartitioner, SparkConf, SparkContext}

object AdTop {
  //数据结构：时间戳，省份，城市，用户，广告，中间字段使用空格分割。
  //需求：统计出每一个省份广告被点击次数的TOP3
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("AdTop")
    val sc = new SparkContext(sparkConf)

    val agentRdd = sc.textFile("data/ad/agent.log").map(_.split(" "))
    //每个省的每种广告数
    val proAndAdRdd = agentRdd.map(x => ((x(1), x(4)), 1)).reduceByKey(_ + _)

    //（省份 ，（广告 数量））
    val proRdd = proAndAdRdd.map(x => (x._1._1, (x._1._2, x._2)))

    val res = proRdd.groupByKey()
      .mapValues { x => x.toList.sortWith((x, y) => x._2 > y._2).take(3) }

    res.collect().foreach(print(_))

    println("----------------------打印1："+res.getNumPartitions)
    println("----------------------打印2："+res.partitions.size)
    val res2= res.partitionBy(new HashPartitioner(5))
    println("----------------------打印3："+res2.partitions.size)
    println("----------------------打印4："+res2.getNumPartitions)
//    res.saveAsTextFile("data/adOutput")

    sc.stop()
  }

}

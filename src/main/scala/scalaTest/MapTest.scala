package scalaTest

import scala.collection.mutable

object MapTest {
  def main(args: Array[String]): Unit = {
    //   创建不可变的map
    //   有序,底层是tuple2
    val scaMap = Map("k1" -> "shui", "k2" -> "huo", "k3" -> 157)
    println(scaMap.getClass)
    print(scaMap.get("k23").getOrElse("不存在該值!"))

    //   创建可变的map
    val scaMuMap = mutable.Map("k1" -> "shui", "k2" -> "huo", "k3" -> 157)
  }
}

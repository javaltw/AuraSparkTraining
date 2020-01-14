package scalaTest

import scala.collection.mutable.ListBuffer

object ListTest {
  def main(args: Array[String]): Unit = {
    //创建数组
    val scalaList = List(1, 2.6, 8, "ag")
    val emptyList = Nil;
    val scListBuffer = ListBuffer(1, 2.6, 8, "ag")
    scListBuffer += "wang"

    println(scalaList.getClass)
    println(emptyList.getClass)
    println(scListBuffer.getClass)
    println(scListBuffer)
    println(scalaList)

    //    LIST后面加元素
    val list2 = scalaList :+ "9"
    println(list2)

    val list3 = 4 :: list2
    println(list3)

    val list4 = "4" :: list3 ::: list3
    println(list4)


  }

}

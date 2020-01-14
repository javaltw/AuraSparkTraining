package hive

import org.apache.spark.sql.SparkSession

object SparkHiveTest01 {
  def main(args: Array[String]): Unit = {
    val sc = SparkSession
      .builder()
            .appName("SparkHiveTest01")
      .enableHiveSupport()
      .master("local[*]")
      .getOrCreate()
    sc.sparkContext.setLogLevel("warn")
    sc.sql("create table if not exists spark_hive_test(name String,task String,code String )");
    sc.sql("show tables");
    sc.stop();

  }

}

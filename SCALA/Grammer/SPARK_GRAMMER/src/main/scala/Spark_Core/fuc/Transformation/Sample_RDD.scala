package Spark_Core.fuc.Transformation

import org.apache.log4j.{Level, Logger}
import org.apache.spark
import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext, rdd}

/**
  * @author asus
  * 以指定的随机种子随机抽样出数量为fraction的数据，
  * withReplacement表示是抽出的数据是否放回，true为有放回的抽样，false为无放回的抽样，
  * fraction:expected size of the sample as a fraction of this RDD's size
  * seed:用于指定随机数生成器种子 用默认的就好。
  * 使用TakeSample可能更简单
  *
  */
object Sample_RDD {
  def main(args: Array[String]): Unit = {
    val conf: SparkConf = new SparkConf().setAppName("p1").setMaster("local[3]")
    val sc: SparkContext = new SparkContext(conf)
    Logger.getRootLogger.setLevel(Level.WARN)
    val rdd1: RDD[Int] = sc.parallelize(1 to 9, 3)

    var sample1: RDD[Int] = rdd1.sample(true,0.34)
    sample1.collect()// Array(1, 2, 2, 8, 8, 9)

  }
}

package Spark_Core.fuc.Transformation

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
  * @author asus
  *         相当于数据库里面的inner join
  *         在类型为(K,V)和(K,W)的RDD上调用，返回一个相同key对应的所有元素对在一起的(K,(V,W))的RDD
  *         join不上的不返回
  */
object Join_RDD {
  def main(args: Array[String]): Unit = {
    val conf: SparkConf = new SparkConf().setAppName("RDD_Filter").setMaster("local[*]")
    val sc: SparkContext = new SparkContext(conf)
    val rdd2: RDD[(String, Int)] = sc.parallelize(List(("a", 2), ("b", 2), ("c", 1)))
    val rdd3: RDD[(String, Int)] = sc.parallelize(List(("a", 5), ("a", 3), ("b", 4), ("a", 9)))
    // 将输入数据集(K,V)和另外一个数据集(K,W)进行Join， 得到(K, (V,W))；该操作是对于相同K
    // 分左右顺序
    val rdd4: RDD[(String, (Int, Int))] = rdd2.join(rdd3)
    rdd4.collect() // Array[(String, (Int, Int))] = Array((a,(2,9)), (a,(2,5)), (a,(2,3)), (b,(2,4)))

  }
}

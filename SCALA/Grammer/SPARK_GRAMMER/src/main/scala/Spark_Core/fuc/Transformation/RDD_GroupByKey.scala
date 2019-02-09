package Spark_Core.fuc.Transformation

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * @author asus
 * groupByKey也是对每个key进行操作，但只生成一个sequence。
 */
object RDD_GroupByKey {
  def main(args: Array[String]): Unit = {
    val conf: SparkConf = new SparkConf().setAppName("RDD_Filter").setMaster("local[*]")
    val sc: SparkContext = new SparkContext(conf)
    val rdd2: RDD[(String, Int)] = sc.parallelize(List(("a",2),("b",2),("c",1)))
    val rdd3: RDD[(String, Int)] = sc.parallelize(List(("a",5),("a",3),("b",4),("a",9)))

    // groupbykey
    val rdd5: RDD[(String, Int)] = rdd2.union(rdd3)
    rdd5.collect()// Array[(String, Int)] = Array((a,2), (b,2), (c,1), (a,5), (a,3), (b,4), (a,9))
    val rdd6: RDD[(String, Iterable[Int])] = rdd5.groupByKey()
    rdd6.collect()// Array[(String, Iterable[Int])] = Array((a,CompactBuffer(2, 5, 3, 9)), (b,CompactBuffer(2, 4)), (c,CompactBuffer(1)))

  }
}

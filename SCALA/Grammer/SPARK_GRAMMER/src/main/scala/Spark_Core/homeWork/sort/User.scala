package Spark_Core.homeWork.sort

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}


// 继承Ordered 重写排序方法
class User(val name: String, val num1: Int, val num2: Int) extends Ordered[User] with Serializable {
  override def compare(that: User): Int = {
    if (this.num1 == that.num1) {
      this.num1 - that.num1
    } else {
      this.num2 - that.num2
    }
  }

  override def toString: String = s"$name,$num1,$num2"
}
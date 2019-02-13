package dataStruct.list

import scala.collection.{TraversableOnce, mutable}
import scala.collection.mutable.ArrayBuffer

/**
  * 用途:数组
  * 作者：sylar-lee
  * 日期:2019/2/2 17:07
  */
object ArrayBufferFuc {

  def main(args: Array[String]): Unit = {

    var array1 = ArrayBuffer(2, 3, 5, 7, 11)
    // map
    val array2: ArrayBuffer[Int] = array1.map(_ * 3)
    // 相当于
    val array3: ArrayBuffer[Int] = array1.map((x: Int) => {
      x * 10
    })
    println(array2) // 6,9,15,21,33

    //filter
    val filter1: ArrayBuffer[Int] = array1.filter(_ > 3)
    println(filter1)

    // flatten 把集合里面的数据压平
    val array4 = Array("a b", "c d")
    //  Array[Array[String]] = Array(Array(a, b), Array(c, d))
    val array5: Array[Array[String]] = array4.map(_.split(" "))
    println(array5)
    val array6: Array[String] = array5.flatten
    println(array6)

    // flatmap 先压平 再map
    val array7: Array[String] = array4.flatMap(_.split(" "))
    println(array7.mkString(","))

    // foreach
    array1.foreach(println(_))
    array1.foreach(f = x => {
      println(x)
    })

    // groupby 返回一个map
    val data: ArrayBuffer[(String, String)] = ArrayBuffer(("a", "1"), ("b", "2"), ("c", "2"))
    val group1: Map[String, ArrayBuffer[(String, String)]] = data.groupBy(_._2)
    println(group1) // Map(2 -> List((b,2), (c,2)), 1 -> List((a,1)))

    // sorted
    val b = ArrayBuffer(1, 7, 2, 9)
    val bSorted = b.sorted
    println(bSorted.mkString(",")) // 1,2,7,9

    // sortby
    val data2: ArrayBuffer[(String, String)] = ArrayBuffer(("a", "1"), ("b", "2"), ("c", "1"))
    val arrayBuffer: ArrayBuffer[(String, String)] = data2.sortBy(_._2)
    println(arrayBuffer)

    // count
    val b2: Int = b.count(_ > 3)
    println(b2) //2

  }

}

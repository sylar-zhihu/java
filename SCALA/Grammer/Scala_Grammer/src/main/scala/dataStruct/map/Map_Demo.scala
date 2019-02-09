package dataStruct.map

import scala.collection.convert.WrapAsJava.mapAsJavaMap

/**
  * 用途:数组
  * 作者：sylar-lee
  * 日期:2019/2/2 17:07
  * 不可变map
  */
object Map_Demo {

  def main(args: Array[String]): Unit = {
    // 不可变构造映射
    val scores: Map[String, Int] = Map("Alice" -> 10, "Bob" -> 3, "Cindy" -> 8)

    // 添加元素会报错
    scores.put("Alice2" ,10)



//
//    // 排序
//    val scores4 = scala.collection.immutable.SortedMap("Alice" -> 10,
//      "Fred" -> 7, "Bob" -> 3, "Cindy" -> 8)
//
//    // 双向链表HashMap
//    val months = scala.collection.mutable.LinkedHashMap("January" -> 1,
//      "February" -> 2, "March" -> 3, "April" -> 4, "May" -> 5,
//      "June" -> 6, "July" -> 7, "August" -> 8, "September" -> 9,
//      "October" -> 10, "November" -> 11, "December" -> 12)



  }

}

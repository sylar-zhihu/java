package dataStruct.map

import scala.collection.convert.WrapAsJava.mapAsJavaMap
import scala.collection.mutable

/**
  * 用途:数组
  * 作者：sylar-lee
  * 日期:2019/2/2 17:07
  * 不可变map
  */
object HashMap_Demo {

  def main(args: Array[String]): Unit = {
    // 可变映射
    val hmap1: mutable.Map[String, Int] = mutable.HashMap("Alice" -> 10, "Bob" -> 3, "Cindy" -> 8)
    // 空映射
    val hmap2 = new mutable.HashMap[String, Int]
    // 使用元祖 创建map
    val hmap3 = mutable.HashMap(("Alice", 10), ("Bob", 3), ("Cindy", 8))

    // 获取值
    val bobsScore: Int = hmap3("Bob")
    println(bobsScore)
    var s2: Option[Int] = hmap3.get("Bob")
    // 没有就返回0
    val s3: Int = hmap3.getOrElse("ss", 0)

    //toList
    val list: List[(String, Int)] = hmap3.toList
    println(list)// List((Bob,3), (Alice,10), (Cindy,8))


    // 添加元素
    hmap3.put("Alice2", 10)
    hmap3("Alice2")= 13
    println(hmap3)

    // 删除元素
    var maybeInt: Option[Int] = hmap3.remove("Alice2")
    // Some(10)
    println(maybeInt)
    //  None
    maybeInt = hmap3.remove("Alice5")
    println(maybeInt)

    // contains 存在
    val bool: Boolean = hmap3.contains("Alice2")

    // 对value进行操作 生成新的map
    val hmap4 = mutable.HashMap(("Alice", 10), ("Bob", 3), ("Cindy", 8))
    val map5: collection.Map[String, Int] = hmap4.mapValues(_+1)
    println(hmap4)
    println(map5)
    // 等同于 但是返回的是inter
    val map6: mutable.Iterable[Int] = hmap4.map(_._2+1)
    println(map6)
    // 一样的效果
    val map7: mutable.HashMap[String, Int] = hmap4.map(x => {
      (x._1, x._2 + 1)
    })
    println(map7)




    ////
    ////    // 遍历
    ////    for ((k, v) <- scores) println(k + " is mapped to " + v)
    ////
    ////    // Key的Set集合
    ////    scores.keySet
    ////
    ////    // 遍历value
    ////    for (v <- scores.values) println(v)
    ////
    ////    // 产生新的Map
    ////    for ((k, v) <- scores) yield (v, k)
    //
    //    // 排序
    //    val scores4 = scala.collection.immutable.SortedMap("Alice" -> 10,
    //      "Fred" -> 7, "Bob" -> 3, "Cindy" -> 8)
    //


  }

}

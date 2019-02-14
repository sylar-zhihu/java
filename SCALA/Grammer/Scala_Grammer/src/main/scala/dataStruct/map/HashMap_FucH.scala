package dataStruct.map

import scala.collection.mutable

/**
  * 用途:数组
  * 作者：sylar-lee
  * 日期:2019/2/2 17:07
  * 不可变map
  */
object HashMap_FucH {

  def main(args: Array[String]): Unit = {

    // 使用元祖 创建map
    val hmap3 = mutable.HashMap(("Alice", 10), ("Bob", 3), ("Cindy", 8))


    println("toList======================")
    //toList
    val list: List[(String, Int)] = hmap3.toList
    println(list) // List((Bob,3), (Alice,10), (Cindy,8))

    println("mapValues======================")
    // mapValues 对value进行操作 生成新的map
    val hmap4 = mutable.HashMap(("Alice", 10), ("Bob", 3), ("Cindy", 8))
    println(hmap4)
    /**
      * mapValues[C](f: B => C): Map[A, C]
      * 传入一个函数把B类型变量，变成C类型变量
      * 对map的value做f函数操作
      */
    var map5: collection.Map[String, Int] = hmap4.mapValues(x=>{x+1})
    println(map5)
    map5 = hmap4.mapValues(_ + 1)
    println(map5)


    println("mapValue 相同效果======================")
    // 等同于 但是返回的是inter
    val map6: mutable.Iterable[Int] = hmap4.map(_._2 + 1)
    println(map6)
    // 一样的效果
    val map7: mutable.HashMap[String, Int] = hmap4.map(x => {
      (x._1, x._2 + 1)
    })
    println(map7)






  }

}

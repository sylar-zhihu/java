package dataStruct.set

import scala.collection.mutable

/**
  * 用途:list
  * 作者：sylar-lee
  * 日期:2019/2/2 17:07
  * 可变set
  */
object HashSet_Demo {

  def main(args: Array[String]): Unit = {

    // 去除重复元素
    val set1: mutable.Set[Int] = mutable.HashSet(1,2,3,4,3)
    println(set1)// Set(1, 2, 3, 4)
    // 添加元素
    set1.add(5)
    println(set1)
    // 删除元素
    set1.remove(5)



  }

}

package dataStruct.list

import scala.collection.immutable
import scala.collection.mutable.ArrayBuffer

/**
  * 用途:list
  * 作者：sylar-lee
  * 日期:2019/2/2 17:07
  * 长度，内容都不可变
  */
object List_Demo {

  def main(args: Array[String]): Unit = {

    var list1: immutable.Seq[Int] = List(4, 2)
    // 改变数据 报错
    // list1(0)=5

    // 无法添加元素
    // list1+=(1,2)

//    创建新的list
    val list2: immutable.Seq[Int] = list1++List(555)
    println(list2)
    println(list1)


  }

}

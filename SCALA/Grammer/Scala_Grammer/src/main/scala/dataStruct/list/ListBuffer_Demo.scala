package dataStruct.list

import scala.collection.{immutable, mutable}
import scala.collection.mutable.ListBuffer

/**
  * 用途:list
  * 作者：sylar-lee
  * 日期:2019/2/2 17:07
  * 长度可变,内容可变
  */
object ListBuffer_Demo {

  def main(args: Array[String]): Unit = {

    var list1: mutable.Seq[Int] = ListBuffer(4, 2)
    // 修改元素
    list1(0)=5
    println(list1)// ListBuffer(5, 2)

    // 添加元素
    // 报错
//    list1+=(1)
//    println(list1)



  }

}

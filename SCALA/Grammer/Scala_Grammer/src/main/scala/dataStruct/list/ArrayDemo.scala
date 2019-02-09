package dataStruct.list

import scala.collection.mutable

/**
  * 用途:数组
  * 作者：sylar-lee
  * 日期:2019/2/2 17:07
  * 定长数组 array,不能添加数据,数据可以改变
  */
object ArrayDemo {

  def main(args: Array[String]): Unit = {

    //  直接初始化
    val newArray =  Array[Int](1,2,3)
    //  不初始化 不赋值就是0
    val numArray = new Array[Int](10)
    // 直接输出
    println(numArray)// [I@35851384
    // 输出 // [I@35851384
    println(numArray.toString)
    // 输出的另一种方法
    println(numArray.mkString(","))
    // 得到长度
    numArray.length

    val s = Array("Hello", "World")
    // 改变第一个元素
    s(0) = "Goodbye"
    // 得到第一个元素
    println(s(0))




    //    遍历
    for (elem <- numArray)
      println(elem)

    //    下标遍历
    for (i <- 0 until numArray.length)
      println(i + ": " + numArray(i))




    //   变长数组与不变数组之间的转换
    // array-> ArrayBuffer
    val arrayBuffer: mutable.Buffer[Int] = numArray.toBuffer
    println(arrayBuffer.toString()) // ArrayBuffer(0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
    // ArrayBuffer->array
    val array: Array[Int] = arrayBuffer.toArray



  }

}

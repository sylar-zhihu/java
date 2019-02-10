package dataStruct.list

import scala.collection.mutable.ArrayBuffer

/**
  * 用途:数组
  * 作者：sylar-lee
  * 日期:2019/2/2 17:07
  * 定长数组 array
  */
object ArrayBufferDemo {

  def main(args: Array[String]): Unit = {

    // 变长 数组
    val my_array = ArrayBuffer[Int](1, 2, 3)


    my_array.append(4)

    println(my_array)


    // foreach
    my_array.foreach(println(_))

    //    遍历
    for (elem <- my_array)
      println(elem)


  }

}

package dataStruct.list

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

/**
  * 用途:数组
  * 作者：sylar-lee
  * 日期:2019/2/2 17:07
  */
object ArrayBufferReduce_Fold {

  def main(args: Array[String]): Unit = {

    // reduce  reduce包含reduceLeft和reduceRight。reduceLeft就是从左向右归约，reduceRight就是从右向左归约。
    // 如果我们不指定reduce是left还是right默认情况下会使用reduceLeft执行操作。
    // 传入的是什么类型，返回值就是什么类型
    var array1 = ArrayBuffer(2, 3, 5, 7, 11)
    val reduce1: Int = array1.reduce(_ + _)
    val reduce2: Int = array1.reduce((x, y) => {
      x + y
    })

    println(reduce1) // 28
    println(reduce2) // 28

    var reduceArray: mutable.Seq[Int] = ArrayBuffer(1, 2, 3)
    println(reduceArray.reduce(_ - _)) // (1-2)-3
    println(reduceArray.reduceRight(_ - _)) //2 1-(2-3)
    println(reduceArray.reduceLeft(_ - _))

    //    val reduceArray2: mutable.Seq[String] =ArrayBuffer("1","2")
    //    println(reduceArray2.reduce(_ + _)) // 123
    //    println(reduceArray2.reduceRight(_ + _))
    //    println(reduceArray2.reduceLeft(_ +_))

    // 如果是两个参数
    val array2 = ArrayBuffer(("a", 1), ("a", 1), ("a", 3))
    // 返回两个参数
    val reduce3: (String, Int) = array2.reduce((x, y) => {
      // 返回必须是两个参数
      (x._1, x._2 + y._2)
    })
    //
    println(reduce3) // (a,5)

    // foldLeft
    array1 = ArrayBuffer(2, 3, 5, 7, 11)
    // 不简写
    array1.foldLeft(0)((sum, i) => {
      sum + i + 1
    })

    // 简写
    // foldLeft reduce多了一个初始值
    reduceArray = ArrayBuffer(1, 2, 3)
    println(reduceArray.foldLeft(0)(_ - _)) // -6 0-1-2-3
    println(reduceArray.foldRight(0)(_ - _)) // 2 1-2-(3-0)
    // 如果是两个参数
    val rearray2 = ArrayBuffer(("a", 1), ("a", 1), ("a", 3))
    // 把所有的数据加起来
    val rearray3: Int = rearray2.foldLeft(0)((x, y) => {
      x + y._2
    })

    println(rearray3)// 5



  }

}

package dataStruct

/**
  * 用途:元组,存放任何类型的数据
  * 作者：ljb
  * 日期:2019/2/2 17:07 
  */
object TupleDemo {

  def main(args: Array[String]): Unit = {
    // 元组操作

    val t: (Int, Double, String) = (1, 3.14, "Fred")
    // 获取元素
    val second: Double = t._2
    println(second)
    val first: Int = t._1
    println(first)

    // 变成迭代器
    val iterator: Iterator[Any] = t.productIterator
    // 变成list
    val list: List[Any] = iterator.toList

  }

}

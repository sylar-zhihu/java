package dataStruct.homeWork

/**
  * 用途:
  * 作者：sylar-lee
  * 日期:2019/2/7 18:49 
  */
object WordCount2 {

  def main(args: Array[String]): Unit = {
    val array1: Array[(String, Int)] = Array(("a", 1), ("b", 2), ("a", 10))
    // Array((a,1), (b,2), (a,10))
    val group: Map[String, Array[(String, Int)]] = array1.groupBy(_._1)
    // Map(b -> Array((b,2)), a -> Array((a,1), (a,10)))
    val wordCount: Map[String, Int] = group.mapValues(_.foldLeft(0)((x, y) => {
      x + y._2
    }))

    println(wordCount)// Map(b -> 2, a -> 11)

  }

}

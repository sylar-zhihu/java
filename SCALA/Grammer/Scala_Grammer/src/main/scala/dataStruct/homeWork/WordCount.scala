package dataStruct.homeWork

/**
  * 用途:
  * 作者：sylar-lee
  * 日期:2019/2/7 18:49 
  */
object WordCount {

  def main(args: Array[String]): Unit = {
    val array1: Array[String] = Array("aa bb aa cc")
    val words: Array[String] = array1.flatMap(_.split(" "))
    // println(words) //  Array[String] = Array(aa, bb, aa, cc)
    val count: Map[String, Array[String]] = words.groupBy(x => x)
    // println(count) //  MMap(bb -> Array(bb), cc -> Array(cc), aa -> Array(aa, aa))
    val wordCount: Map[String, Int] = count.mapValues(_.length)
    // Map(bb -> 1, cc -> 1, aa -> 2)
  }

}

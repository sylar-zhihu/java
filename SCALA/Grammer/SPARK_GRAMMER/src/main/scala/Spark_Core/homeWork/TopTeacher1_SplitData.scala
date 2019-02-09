package Spark_Core.homeWork

/**
  * 用途:
  * 作者：sylar-lee
  * 日期:2019/2/6 13:55 
  */
object TopTeacher1_SplitData {

  def main(args: Array[String]): Unit = {
    val line="http://javaee.edu360.cn/laoyang"
    val splits: Array[String] = line.split("/")

//    for(data<-splits){
//      println(data)
//    }

    val sub=splits(2).split("\\.")(0)
    val teacher=splits(3)

    println(sub)
    println(teacher)


  }

}

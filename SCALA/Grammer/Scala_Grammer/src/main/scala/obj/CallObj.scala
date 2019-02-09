package obj

/**
  * 用途:
  * 作者：sylar-lee
  * 日期:2019/2/7 11:28 
  */
object CallObj {

  def main(args: Array[String]): Unit = {
    // 调用成员变量
    println(MyObj.word)
    // 调用方法
    MyObj.say()
  }

}

package yinshizhuanhuan_p

/**
  * 用途:
  * 隐式值
  * 作者：ljb
  * 日期:2019/2/9 16:05 
  */
object Demo_4_var {

  def main(args: Array[String]): Unit = {

    implicit val str1: String = "jack" //隐式值

    def hello(implicit name: String): Unit = { // hello$1
      println(name + " hello")

      def hello(): Unit = { // hello$2
        println("xxxx")
      }
    }

//    hello // hello$1(str1)  使用隐式值不要带()
//
//    def hello(): Unit = { //函数名
//      println("xx")
//    }

  }

}

package yinshizhuanhuan_p

/**
  * 用途:
  * 隐式值
  * 作者：ljb
  * 日期:2019/2/9 16:05 
  */
object Demo_3_var {

  def main(args: Array[String]): Unit = {

    // implicit修饰变量是隐式值
    implicit val str1: String = "jack"

    // implicit 修饰变量 是隐式参数
    def hello(implicit name: String): Unit = {
      println(name + " hello")
    }

    // 调用 不需要括号 不然会报错
    hello
    // 报错
    // hello()
  }

}

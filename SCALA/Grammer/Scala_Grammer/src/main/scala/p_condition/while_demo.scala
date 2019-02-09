package p_condition

/**
  * 用途:
  * 作者：sylar-lee
  * 日期:2019/2/2 15:21
  */
object while_demo {

  def main(args: Array[String]): Unit = {
    var r = 1
    var n = 10
    // while 循环
    while (n > 0) {
      r = r * n
      n -= 1
      println(r)
    }

    r = 1
    n = 10


    // scala没有break 只能这样使用
    import scala.util.control.Breaks._

    r = 1
    n = 10
    // break
    breakable {
      while (n > 0) {
        r = r * n
        n -= 1
        println(r)
        if (r == 720) break;
      }
    }

  }

}

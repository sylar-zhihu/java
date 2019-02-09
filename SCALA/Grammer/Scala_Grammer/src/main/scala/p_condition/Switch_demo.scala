package p_condition

/**
  * 用途:
  * 作者：sylar-lee
  * 日期:2019/2/2 15:21
  */
object Switch_demo {

  def main(args: Array[String]): Unit = {
    var sign = 0
    for (ch <- "+-!") {

      //  case _ 相当于default
      ch match {
        case '+' => sign = 1
        case '-' => sign = -1
        case _ => sign = 0
      }

      println(sign) // 1 -1 0
    }

    // 也可以用fot
    for (ch <- "+-!") {
      sign = ch match {
        case '+' => 1
        case '-' => -1
        case _ => 0
      }
      println(sign)
    }

    //如果匹配，则把字符转换成10进制。
    for (ch <- "+-3!") {
      var sign = 0
      var digit = 0

      ch match {
        case '+' => sign = 1
        case '-' => sign = -1
        case _ if Character.isDigit(ch) => digit = Character.digit(ch, 10)
        case _ => sign = 0
      }

      println(ch + " " + sign + " " + digit)
    }

    //    import java.awt._
    //
    //    val color = SystemColor.textText
    //    color match {
    //      case Color.RED => "Text is red"
    //      case Color.BLACK => "Text is black"
    //      case _ => "Not red or black"
    //    }

  }

}

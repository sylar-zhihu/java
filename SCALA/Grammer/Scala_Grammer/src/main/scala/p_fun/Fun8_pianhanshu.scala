package p_fun

/**
  * 偏函数
  */
object Fun8_pianhanshu {

  def main(args: Array[String]): Unit = {

    // 普通的函数定义
    def fuc(str: String) = {
      if (str.equals("a")) {
        97
      } else {
        0
      }
    }

    /**
      * 偏函数的函数定义 PartialFunction[A,B] 指定是偏函数
      * A 传入类型
      * B 返回值类型
      * 不满足任意case 不会报错
      * @return
      */
    def fuc1: PartialFunction[String, Int] = {
      // 必须使用case
      case "a" => 97
      case _ => 0
    }

    println(fuc("a")) // 97
    println(fuc1("a")) // 97
  }

}

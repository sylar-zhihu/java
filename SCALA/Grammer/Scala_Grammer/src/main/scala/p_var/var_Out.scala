package p_var

object var_Out {

  // 打印输出变量
  def main(args: Array[String]) {

    // 方法1
    var a = "123"
    println("a:" + a)
    // 这种最常用
    println(s"$a,${a + 10}")

  }
}

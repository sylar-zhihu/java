package p_var

object var_Out {
  // object 放静态的方法和变量

  def main(args: Array[String]) {

    var a = "123"
    println("a:" + a)
    // 这种最常用
    println(s"$a,${a + 10}")

  }
}

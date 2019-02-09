package p_var

//
object var_Any {

  // Any表示任意类型，它是所有类型的父类。
  def main(args: Array[String]) {

    def f(a: Any): Unit = {
      println(a)
    }

    f(1)
    f("a")

  }
}

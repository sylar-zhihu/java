package p_fun

/**
  * 柯里化
  * 接受多个参数的函数都可以转化为接受一个参数的函数
  * 这个转化过程叫做柯里化
  */
object Fun7_kelihua {

  def main(args: Array[String]): Unit = {

    def multy(x: Int, y: Int) = {
      x * y
    }

    println(multy(3, 4))

    // 柯里化 把两个变量转化为一个参数
    def multy2(x: Int) = {
      (y: Int) => x * y
    }

    println(multy2(3)(4))

  }

}

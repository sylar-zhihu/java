package p_fun

/**
  * 闭包就是一个函数把外部不属于自己的对象也包含进来
  * 再也改变不了传入的那个数字
  */
object Fun6_bibao {

  def main(args: Array[String]): Unit = {

    // 返回的是一个函数
    def mulby(x: Double) = {
      (y: Double) => x * y
    }

    val  triple = mulby(3)
    println(triple(3))

    val  half = mulby(0.5)
    println(half(3))
  }

}

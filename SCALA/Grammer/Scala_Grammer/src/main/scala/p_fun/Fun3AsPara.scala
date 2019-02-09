package p_fun

/**
  * 方法作为参数 给方法
  */
object Fun3AsPara {

  def main(args: Array[String]): Unit = {

    def plus(x: Double) ={3 * x}

    // map 是一个方法 接受的参数是函数
    val array: Array[Double] = Array(3.14, 1.42, 2.0).map(plus)

    println(array.toBuffer)

  }

}

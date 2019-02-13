package p_fun


object Fun2_AsPara {

  /**
    * 方法 函数 作为函数的参数
    * @param args
    */
  def main(args: Array[String]): Unit = {

    // 定义一个函数
    val triple: Double => Double = (x: Double) => 3 * x
    // 定义一个方法
    def tripleM(x: Double): Double = {
      x * 3
    }

    // 传入函数名做为参数
    println(Array(3.14, 1.42, 2.0).map(triple).toBuffer)
    // 会报错 加()表示调用
    //    Array(3.14, 1.42, 2.0).map(triple())

    // 传入方法作为参数 会把方法转化为函数
    println(Array(3.14, 1.42, 2.0).map(tripleM).toBuffer)


  }

}

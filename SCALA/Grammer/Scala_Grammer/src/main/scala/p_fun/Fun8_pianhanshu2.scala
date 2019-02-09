package p_fun

/**
  * 偏函数 在array中的应用
  */
object Fun8_pianhanshu2 {

  def main(args: Array[String]): Unit = {

    val array1: Array[Int] = Array(1, 2, 3)

    def f1: PartialFunction[Int, Int] = {
      case i: Int => i * 10
    }

    // 需要传入一个偏函数 把每个数据乘上10
   println(array1.collect(f1).toBuffer)
  }

}

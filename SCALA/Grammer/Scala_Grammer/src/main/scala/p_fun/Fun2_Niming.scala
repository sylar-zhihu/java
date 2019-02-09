package p_fun

object Fun2_Niming {

  def main(args: Array[String]): Unit = {

    // 匿名函数
    val triple = (x: Double) => 3 * x

    Array(3.14, 1.42, 2.0).map(triple)
    // 包含在()中
    Array(3.14, 1.42, 2.0).map((x: Double) => 3 * x)
    // 包含在{}中
    Array(3.14, 1.42, 2.0) map { (x: Double) => 3 * x }

  }

}

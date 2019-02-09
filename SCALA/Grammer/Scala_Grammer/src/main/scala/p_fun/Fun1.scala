package p_fun

object Fun1 {

  def main(args: Array[String]): Unit = {
    // 定义
    val triple = (x: Double) => {
      3 * x
    }
    // 证明
    println(triple.toString()) // <function1> 1代表有一个参数
    // 使用
    println(triple(5))
  }

}

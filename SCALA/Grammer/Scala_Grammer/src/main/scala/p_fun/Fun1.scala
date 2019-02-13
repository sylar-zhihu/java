package p_fun

object Fun1 {

  def main(args: Array[String]): Unit = {
    // 定义 返回值是double=>double 不写返回类型，自动推断
    val triple: Double => Double = (x: Double) => {
      3 * x
    }
    // 证明
    println(triple.toString()) // <function1> 1代表有一个参数
    // 使用
    println(triple(5))
  }

}

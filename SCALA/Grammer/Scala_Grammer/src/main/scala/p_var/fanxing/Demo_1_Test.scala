package p_var.fanxing

/**
  * 传入的类型是泛型T
  *
  * @param content
  * @tparam T
  */

object Demo_1_Test {

  def main(args: Array[String]): Unit = {
    // 调用
    val myCloth: Cloth[String, String, Int] = new Cloth[String, String, Int]("man", "red", 59)
  }
}
package p_fun

object Try_demo {

  def main(args: Array[String]): Unit = {

    // 异常的为Nothing
    def root(x: Double) = {
      if (x >= 0) {
        Math.sqrt(x)
      } else throw new IllegalArgumentException("x should not be negative")
    }

    try {
      println(root(4))
      println(root(-4))
    } catch {
      case e: Exception => println(e)
    } finally {
      println("finally....")
    }

  }

}

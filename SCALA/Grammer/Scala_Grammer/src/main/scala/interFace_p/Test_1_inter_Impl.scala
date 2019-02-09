package interFace_p

/**
  * 实现接口
  * scala 只有继承,没有java的implement
  */
object Test_1_inter_Impl extends inter_Demo1 {
  // 实现方法
  override def hello(name: String): Unit = {
    println("hello " + name)
  }

  // 重写的方法 也可以重写
  override def hello2(name: String): Unit = {
    println("inter_Demo1_Impl "+name)
  }

  def main(args: Array[String]): Unit = {
    Test_1_inter_Impl.hello("aa")
    Test_1_inter_Impl.hello2("bb")
  }
}

package interFace_p

/**
  * 生成一个类，使用with关键字可以使用接口的方法
  * 可以with多个 格式：with a with b
  * 也可以使用在class上 定义的时候加
  */
object Test_2_class_with_inter {

  def main(args: Array[String]): Unit = {
    // 继承接口
    val help1 = new Help_Class() with inter_Demo_help1
    // 使用接口的方法
    help1.demo2Impl("aa")

  }
}


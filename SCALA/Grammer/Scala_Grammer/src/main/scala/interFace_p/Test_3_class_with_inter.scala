package interFace_p

/**
  * 在类主构造上使用，必须先使用extends 再使用with
  */
object Test_3_class_with_inter extends inter_Demo_help1 with inter_Demo_help2 {

  def main(args: Array[String]): Unit = {
    // 继承接口
    val help1 = new Help_Class() with inter_Demo_help1
    // 使用接口的方法
    help1.demo2Impl("aa")

  }
}


package interFace_p

/**
  * 在类主构造上使用，必须先使用extends 再使用with
  */
object Test_4_Type extends inter_Demo3_Type {

  override type T = String

  def main(args: Array[String]): Unit = {
    this.tType("Test_4_Type")

  }
}


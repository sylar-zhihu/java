package interFace_p

/**
  * 不指定类型,由继承的类指定
  */
trait inter_Demo3_Type {

  // 不指定类型
  type T

  // 由子类传入类型
  def tType(t: T): Unit = {
    println("tType :" + t)
  }

}

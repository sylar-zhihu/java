package p_class

/**
  * 继承
  */
object Class_3_AbsClass_Test extends Class_3_AbsClass {

  // 继承需要实现 抽象方法
  override def eat(food: String): String = {
    return "Class_3_AbsClass_Test eat"
  }


}

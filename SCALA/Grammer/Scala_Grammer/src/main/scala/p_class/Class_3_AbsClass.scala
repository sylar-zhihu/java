package p_class

/**
  * abstract 关键字 定义抽象类
  * 可以有实现，也可以没实现
  */
abstract class Class_3_AbsClass {

  // 没有实现
  def eat(food: String): String

  // 实现
  def eatImpl(food: String): String = {

    return food + " eatImpl"
  }

}

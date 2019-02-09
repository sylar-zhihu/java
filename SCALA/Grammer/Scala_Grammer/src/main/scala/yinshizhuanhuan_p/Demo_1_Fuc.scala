package yinshizhuanhuan_p

/**
  * 用途:
  * 隐式转换函数是以implicit关键字声明的带有单个参数的函数。
  * 这种函数将会自动应用，将值从一种类型转换为另一种类型
  * 作者：ljb
  * 日期:2019/2/9 16:05 
  */
object Demo_1_Fuc {


  def main(args: Array[String]): Unit = {

    /**
      * implicit 关键字 单个参数
      * Double 是输入类型, Int 是转换后的类型
      * 和作用域和有关系
      */
    implicit def f1(d: Double): Int = {
      d.toInt
    }

    // 直接转换为3
    val a: Int = 3.5
    println(a)
  }

}

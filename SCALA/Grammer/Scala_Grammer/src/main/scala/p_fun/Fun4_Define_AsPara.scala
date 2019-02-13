package p_fun

import math._

/**
  * 自己实现一个这样的参数
  */
object Fun4_Define_AsPara {

  def main(args: Array[String]): Unit = {

    // 接受函数作为参数的函数，叫做高阶函数
    // f为函数 输入一个int,返回一个int
    // {}内为函数实现
    def high_Fuc(f: (Int) => Int, a: Int): Int = {
      f(a)
    }

    def f2(a: Int): Int = {
      a
    }

    println(high_Fuc(f2,1))// 1

  }

}

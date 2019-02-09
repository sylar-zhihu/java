package p_fun

import math._

/**
  * 自己实现一个这样的参数
  */
object Fun4AsPara {

  def main(args: Array[String]): Unit = {

    // 接受函数作为参数的函数，叫做高阶函数
    // f为函数 输入一个int,返回一个int
    // {}内为函数实现
    def f1(f: (Int) => Int, a: Int) = {
      f(a)
    }

    def f2(a: Int) = {
      a
    }

    println(f1(f2,1))// 1



  }

}

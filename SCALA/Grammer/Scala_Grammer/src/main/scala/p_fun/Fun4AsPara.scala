package p_fun

import math._

object Fun4AsPara {

  def main(args: Array[String]): Unit = {

    // 接受函数作为参数的函数，叫做高阶函数
    // f为函数
    // {}内为函数实现
    def f1(f: (Int) => Int, a: Int) = {
      f(a)
    }

    def f2(a: Int) = {
      a
    }

    // 1
    println(f1(f2,1))

    def valueAtOneQuarter(f: (Double) => Double) = {
      f(-0.25)
    }

    println(valueAtOneQuarter(abs))

    // 产出函数
    def mulBy(factor: Double) = (x: Double) => factor * x

    val quintuple = mulBy(5)
    quintuple(20)

  }

}

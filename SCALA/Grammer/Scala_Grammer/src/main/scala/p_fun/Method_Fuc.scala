package p_fun

// 本质上说来，没啥区别
object Method_Fuc {

  def main(args: Array[String]): Unit = {

    // 什么都不省略
    // 定义一个函数fun1，参数是两个Int类型，返回值是一个Int类型
    def fun1(x: Int, y: Int): Int = {
      return x + y
    }


    // 方法不能不带参数使用
    // 会报错，错误提示 Missing arguments for method fun1(Int, Int) 证明是个方法
    // println(fun1) // 证明是个方法

    // 方法转化为函数
    val fuc2: (Int, Int) => Int = fun1 _

    // 证明是函数
    println(fuc2)// <function2>
    // 使用
    println(fuc2(1, 2))

  }
}

package p_fun
object Method_Define {

  def main(args: Array[String]): Unit = {

    // 不省略
    // 定义一个函数fun1，参数是两个Int类型，返回值是一个Int类型
    def fun1(x: Int, y: Int): Int = {
      return x + y
    }


    // println(fun1) // 证明是个方法

    // 方法转化为函数
    val fuc2=fun1 _

    // 证明是函数
    println(fuc2.toString())
    println(fuc2(1,2))

    // 省略返回类型 可以自行推断
    // return 可以省略 用最后一行的值作为返回
    // 如果有 return 就一定要写返回类型
    def abs(x: Double) = {
      if (x >= 0) x else -x
    }

    println(abs(5))

    // 没有返回值，全部去掉
    def show(x: String) {
      println(x)
    }

    show("my show")


    //  如果方法一行搞定，{}可以省略
    def plus(x: Double) = 3 * x

    // 如果没有参数括号可以省略 不要这样定义
    def plus2 = println("plus2")
    // 因为只能这样使用
    plus2



    // 变长参数
    def sum(args: Int*) = {

      var result = 0
      for (arg <- args) result += arg
      result
    }

    var s = sum(1, 4, 9, 16, 25)
    println(s)
    s = sum()
    println(s)
  }
}

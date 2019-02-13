package p_fun

/**
  * 函数一步一步简写
  */
object Fun3_AsPara_Abbreviation {

  def main(args: Array[String]): Unit = {

    val list1: List[Int] = List(1, 2, 3)

    // 什么都不简写 定义一个叫f的函数 传入map中
    println(list1.map(f = (x: Int) => {
      3 * x
    }))


    // 省略函数名字 f
    println(list1.map((x: Int) => 3 * x))
    // 省略类型
    println(list1.map((x) => 3 * x))
    // 单个参数省略括号
    println(list1.map(x => 3 * x))
    // 变量在=>只出现一次，用 _来代替
    println(list1.map(3 * _))
  }

}

package p_var

object var_1_basic {
  // object 放静态的方法和变量

  def main(args: Array[String]) {
    // 入口函数 都是这样写
    // 声明变量必须初始化
    val s = 1
    // 不可变类型
    //s=2 // 重新赋值报错
    var str = "itcast" // 可变类型  可以不定义数据类型会自动推断
    val str2: String = "aaa" // 定义变量同时指定数据类型

     println("hello scala")
  }
}

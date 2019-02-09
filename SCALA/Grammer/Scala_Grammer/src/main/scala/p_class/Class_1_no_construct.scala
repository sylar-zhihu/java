package p_class

// 定义一个对象 没有参数 括号可以省略
class Class_1_no_construct {

  var name: String = "aa"
  // _ var类型可以使用
  var name2: String = _ // String 类型默认为null
  var num: Int = _ //Int 类型 默认为 0

  def say(): Unit = {
    println(name + " say")
  }
}




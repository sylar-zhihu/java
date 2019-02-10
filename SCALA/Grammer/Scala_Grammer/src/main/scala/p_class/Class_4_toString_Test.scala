package p_class

// 定义一个对象 没有参数 括号可以省略
object Class_4_toString_Test {

  def main(args: Array[String]): Unit = {
    val demo1: Class_4_toString = new Class_4_toString("aa")



    // 加不加括号都行
    println(demo1.toString())
    println(demo1.toString)

  }

}




package p_class

// 私有构造器 加上private 外部无法访问
// private放在变量上 修饰的是变量
// 放在class前面修饰的是这个类
class Class_2_construct_private private(var id: Int) {

  // 辅助构造器 也可以加上private
  private def this(id: Int, name: String, age: Int) {
    // 第一句必须调用主构造器
    this(id)
  }


  def say(): Unit = {
    println( id)
  }
}




package p_class

// 定义一个对象 主构造器 执行对象体里面所有的代码 不包括函数
// 主构造器的参数，自动定义为成员变量,默认在类外面无法访问
// 如果要访问 需要加val 或者var
class Class_2_construct(var id: Int) {
  // 一般用来初始化无法初始化的参数
  var age: Int = _
  var name: String = _

  // 辅助构造器
  def this(id: Int, name: String, age: Int) {
    // 第一句必须调用主构造器
    this(id)
    this.name = name
    this.age = age
  }

  def say(): Unit = {
    println(name + age + id)
  }
}




package yinshizhuanhuan_p

/**
  * 用途:
  * 隐式类
  * 其所带的构造参数有且只能有一个
  * 隐式类必须被定义在“类”或“伴生对象”或“包对象”里，即隐式类不能是 顶级的(top-level  objects)。
  * 隐式类不能是case class（case class在后续介绍 样例类）
  * 作用域内不能有与之相同名称的标识符
  * 作者：ljb
  * 日期:2019/2/9 16:05 
  */
object Demo_4_class {

  def main(args: Array[String]): Unit = {

    /**
      * DB1会对应生成隐式类 如果创建一个MySQL1类型的对象
      * 就可以调用这个方法
      * @param m
      */
    implicit class DB1(val m: MySQL1) {
      def addSuffix(): String = {
        m + " scala"
      }
    }
    val mysql1 = new MySQL1()
    mysql1.sayOk()
    //mysql1.addSuffix() ==> DB1$1(mysql1).addSuffix()
    //DB1$1(mysql1)返回的类型是 ImplicitClass$DB1$2
    println(mysql1.addSuffix())
  }

}

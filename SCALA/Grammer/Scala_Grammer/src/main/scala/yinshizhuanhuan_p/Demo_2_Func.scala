package yinshizhuanhuan_p

/**
  * 用途:
  * 隐式转换函数是以implicit关键字声明的带有单个参数的函数。
  * 这种函数将会自动应用，将值从一种类型转换为另一种类型
  * 作者：ljb
  * 日期:2019/2/9 16:05 
  */
object Demo_2_Func {

  // 加入隐式转换函数 把mysql对象转换为DB对象
  implicit def addDelete(mysql:MySQL): DB = {
    new DB //
  }

  def main(args: Array[String]): Unit = {


    val mysql = new MySQL
    mysql.insert()
    // 可以使用 DB的delete方法
    mysql.delete()

  }

}

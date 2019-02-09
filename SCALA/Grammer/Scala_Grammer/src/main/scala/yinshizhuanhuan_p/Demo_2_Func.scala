package yinshizhuanhuan_p

/**
  * 用途:
  * 添加新的方法
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

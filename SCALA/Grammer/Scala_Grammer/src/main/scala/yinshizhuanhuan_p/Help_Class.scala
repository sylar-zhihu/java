package yinshizhuanhuan_p

/**
  * 用途:
  * 隐式转换函数是以implicit关键字声明的带有单个参数的函数。
  * 这种函数将会自动应用，将值从一种类型转换为另一种类型
  * 作者：ljb
  * 日期:2019/2/9 16:05 
  */
class MySQL {
  def insert(): Unit = {
    println("insert")
  }
}

class DB {
  def delete(): Unit = {
    println("delete")
  }
}


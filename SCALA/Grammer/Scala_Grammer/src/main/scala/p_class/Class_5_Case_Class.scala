package p_class

/**
  * 样例类，会生成两个class文件
  * 自动实现序列化
  * 样例类用case关键字进行声明，是一个类
  * 样例类是为模式匹配而优化的类
  * 构造器中的每一个参数都成为val——除非它被显式地声明为var
  * 在样例类对应的伴生对象中提供apply方法让你不用new关键字就能构造出相应的对象
  * 提供unapply方法让模式匹配可以工作
  * 将自动生成toString、equals、hashCode和copy方法(有点类似模板类，直接给生成，供程序员使用)
  * 除上述外，样例类和其他类完全一样。你可以添加方法和字段，扩展它们
  *
  * @param a
  */
case class Class_5_Case_Class(a: String) {

}




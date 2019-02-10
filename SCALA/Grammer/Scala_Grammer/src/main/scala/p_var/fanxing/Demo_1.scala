package p_var.fanxing

/**
  * 传入的类型是泛型T
  *
  * @param content
  * @tparam T
  */

// 有[]这种括号的就是泛型
class Message[T](content: T) {

}

// 继承的时候实现
class Message2(content: String) extends Message {
}

// 另一种写法
class Message3[Int](content: Int) extends Message[Int](content) {
}

// 多个参数
class Cloth[A, B, C](val sex: A, val color: B, val size: C) {

}
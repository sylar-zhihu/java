package interFace_p

/**
  * 相当于java的接口，可以实现，也可以不实现
  */
trait inter_Demo2 {

  // 可以不赋值，继承的时候，必须重写
  val a:String

  // final 无法重写
  final  val b: String ="bbb"

  // final 方法无法重写
  final def hello2(name: String): Unit = {
    println("hello2 " + name)
  }

}

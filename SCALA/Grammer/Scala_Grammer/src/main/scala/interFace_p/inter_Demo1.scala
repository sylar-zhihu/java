package interFace_p

/**
  * 相当于java的接口，可以实现，也可以不实现
  */
trait inter_Demo1 {

  //不实现
  def hello(name: String)

  // 实现
  def hello2(name: String): Unit = {
    println("hello2 " + name)
  }

}

package obj

import scala.collection.mutable.ArrayBuffer

object Apply_Update {

  def main(args: Array[String]) {


    val array1: ArrayBuffer[Int] = ArrayBuffer(1,2,3)
    println(array1)
    // 实际上调用的是
    val array2: ArrayBuffer[Int] = ArrayBuffer.apply(1, 2, 3)
    println(array2)

    array1(0)=10
    println(array1)
    // 实际上调用的是
    array1.update(1,10)
    println(array1)

  }
}

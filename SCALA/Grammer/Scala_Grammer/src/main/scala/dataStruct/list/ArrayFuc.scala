package dataStruct.list

import scala.collection.mutable.ArrayBuffer

/**
  * 用途:数组
  * 作者：sylar-lee
  * 日期:2019/2/2 17:07
  */
object ArrayFuc {

  def main(args: Array[String]): Unit = {

    val array1 = Array(2, 3, 5, 7, 11)
    // map
    val array2: Array[Int] = array1.map(_ * 3)
    // 相当于
    val array3: Array[Int] = array1.map((x: Int) => {
      x * 10
    })
    println(array2.mkString(",")) // 6,9,15,21,33

    // flatten
    val array4 = Array("a b","c d")
    //  Array[Array[String]] = Array(Array(a, b), Array(c, d))
    val array5: Array[Array[String]] = array4.map(_.split(" "))
    val array6: Array[String] = array5.flatten



    // 产生新的数组
    val result = for (elem <- array1) yield 2 * elem
    println(result.mkString(","))

    for (elem <- array1 if elem % 2 == 0) yield 2 * elem

    // _带表数组里面的每一个元素
    array1.filter(_ % 2 == 0).map(2 * _)

    // 得到最大值
    ArrayBuffer("Mary", "had", "a", "little", "lamb").max

    val b = ArrayBuffer(1, 7, 2, 9)

    //排序
    val bSorted = b.sorted
    println(bSorted.mkString(","))

    val a1 = Array(1, 7, 2, 9)

    // 形成String 用来数据
    println(a1.mkString(" and ")) // 1 and 7 and 2 and 9
    println(a1.mkString("<", ",", ">")) // <1,7,2,9>
    // 直接输出是对象的
    println(a1.toString) // [I@60addb54

    //    // 更多方法
    //    val a2 = Array(1, -2, 3, -4, 5)
    //    val b2 = ArrayBuffer(1, 7, 2, 9)
    //
    //    // 统计大于0的个数
    //    a2.count(_ > 0)
    //
    //    //
    //    b2.append(1, 7, 2, 8)
    //
    //    b2
    //
    //    b2.appendAll(a2)
    //
    //    b2
    //
    //    b2 += 4 -= 7
    //
    //    b2
    //
    //    //将b2中的数据copy到a2中，a2的空间为5
    //    b2.copyToArray(a2)
    //    a2
    //
    //    val xs = Array(1, "Fred", 2, 9)
    //    b2.copyToArray(xs)
    //    xs
    //
    //    b2
    //    // 加到20项，用-1填充
    //    b2.padTo(20, -1)
    //
    //    (1 to 10).padTo(20, -1) // Note that the result is a Vector, not a Range

  }

}

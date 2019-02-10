package p_var.compare

class Student(val height: Int, val age: Int) extends Ordered[Student] {

  /**
    *
    * @param that 比较的另一个对象的类型
    * @return 返回值lint 大于0就表示大
    */
  override def compare(that: Student): Int = {

    if (this.height == that.height) {
      return this.age - that.age
    } else {
      return this.height - that.height
    }

  }

  override def toString: String = {
    s" height $height,age: $age"
  }
}

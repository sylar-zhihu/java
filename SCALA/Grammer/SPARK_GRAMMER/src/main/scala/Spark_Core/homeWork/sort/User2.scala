package Spark_Core.homeWork.sort

// 继承Ordered 重写排序方法
class User2( val num1: Int, val num2: Int) extends Ordered[User2] with Serializable {

  override def compare(that: User2): Int = {
    if (this.num1 == that.num1) {
      this.num1 - that.num1
    } else {
      this.num2 - that.num2
    }
  }

}
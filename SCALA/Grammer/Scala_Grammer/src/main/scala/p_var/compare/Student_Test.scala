package p_var.compare


object Student_Test{

  def main(args: Array[String]): Unit = {
    val student: Student = new Student(1,2)
    val student2: Student = new Student(1,3)
    val student3: Student = new Student(2,3)

    val list1: List[Student] = List(student,student2,student3)

    list1.sorted.foreach(println(_))
  }
}

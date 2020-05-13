class Student(name: String, age: Int) {
  def getName(): String = {
    this.name
  }
}

//object Student {
//  def apply(name: String, age: Int): Student = {
//    new Student(name, age)
//  }
//}

//case keyword, identifier and optional parameters
case class Customer(id: Int, name: String)

object CaseClasses extends App {
  val student1 = new Student("Kamal", 23)
  val customer1 = Customer(1, "John")
  val customer2 = Customer(name = "Peter", id = 2)
  val customer3 = customer1.copy(id = 3)
  val customer4 = Customer(2, "Peter")

  val result = student1 match {
    case s: Student => s.getName()
    case _ => "Nothing matched"
  }

  println(result)
  println(customer2.equals(customer4))
  println(customer1.toString)
}

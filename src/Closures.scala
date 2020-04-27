object Function extends App {

  //Function
  val multiplyByTwo = (x: Int) => 2 * x
  val add = (a: Long, b: Long) => a + b

  println(multiplyByTwo(5))
  println(add(3, 4))
}

object Closures extends App {
  //Closure
  val factor = 5
  val closure1 = (i: Int) => i * factor

  println(closure1(3))
}
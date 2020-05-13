object Functions extends App {
  val list = List(1, 2, 3)

  //Simple functions
  val sum = (a: Int, b: Int) => a + b
  val multiplyByTwo = (x: Int) => x * 2
  val addBraces = (a: Int) => "{" + a.toString + "}"

  //Higher order function
  val printSmart = (f: Int => String, b: Int) => println(f(b))

  println(sum(3, 2))
  println(multiplyByTwo(5))
  printSmart(addBraces, 6)
  println(list.map(multiplyByTwo))
}

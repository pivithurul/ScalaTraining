object ByNameParameters extends App {
  //Normal way
  def when[A](test: Boolean, whenTrue: A, whenFalse: A): A =
    test match {
      case true => whenTrue
      case false => whenFalse
    }

  //Using by name parameters
  def when[A](test: Boolean, whenTrue: => A, whenFalse: => A): A =
    test match {
      case true => whenTrue
      case false => whenFalse
    }


  //More examples
  def whileLoop(condition: => Boolean)(body: => Unit): Unit =
    if (condition) {
      body
      whileLoop(condition)(body)
    }

  var i = 2

  whileLoop(i > 0) {
    println(i)
    i -= 1
  }
}

//Explanation
object Demo {
  def main(args: Array[String]) {
    delayed(time())
  }

  def time(): Long = {
    println("Getting time in nano seconds")
    System.nanoTime
  }

  def delayed(t: => Long): Unit = {
    println("In delayed method")
    println("Param: " + t)
  }
}

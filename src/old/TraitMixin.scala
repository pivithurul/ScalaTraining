//class TraitMixin {
//
//}
//
//trait Print {
//  def print()
//}
//
//abstract class PrintA4 {
//  def printA4()
//}
//
//class A6 extends PrintA4 with Print {
//  override def printA4(): Unit = {
//    println("print A4")
//  }
//
//  override def print(): Unit = {
//    println("print")
//  }
//}
//
//object print extends App {
//
//  def isOdd(num: Int): Boolean = {
//    if(num % 2 == 0)
//      false
//    else
//      true
//  }
//
//  val a6 = new A6
//  a6.print()
//  a6.printA4()
//  DDD.print()
//}
//
//object DDD extends Print {
//  override def print(): Unit = ???
//}

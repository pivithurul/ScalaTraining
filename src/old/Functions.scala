//object Test2 extends App {
//  val sq = (x: Int) => x * x
//  val add = (x: Int, y: Int) => x + y
//  val twice = (x: Int) => 2 * x
//
//  val numList = List(1, 2, 3, 4)
//
//  add(2,1)
//
//  numList.map(sq)
//  numList map sq
//  numList.map(x => sq(x))
//  numList.map(sq(_))
//}
//
//class Decorator(left: String, right: String) {
//  def layout[B](x: B) = left + x.toString() + right
//}
//object FunTest extends App {
//  def apply(f: Int => String, v: Int) = f(v)
//  val decorator = new Decorator("[", "]")
//  println(apply(decorator.layout, 7))
//}
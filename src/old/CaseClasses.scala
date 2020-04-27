//trait Foo
//
//case class Fun(num: Int) extends Foo
//
//case class Var(num: Int, body: Foo) extends Foo
//
//case class Call(f: Foo, g: Foo) extends Foo
//
//case class V1() extends Foo
//
//object Test1 extends App {
//
//  def add(x : Foo): Int = {
//    x match {
//      case Fun(a) => a
//      case Var(a,b) => a + add(b)
//      case Call(a,b) => add(a) + add(b)
//      case _ => 0
//    }
//  }
//
////  val a = "454543534534"
////  println(a.toLong)
//  val fun = Fun(1)
//  val var1 = Var(3, fun)
//  val call = Call(fun, var1)
//  val v1 = V1()
//
////  println(add(fun))
//  println(add(var1))
////  println(add(call))call
////  println(add(v1))
//
//}
//object ForComprehension extends App {
//  def f1(): Option[String] = {
//    Some("10")
//  }
//
//  def f2(input: String): Option[Int] = {
//    Some(input.toInt)
//  }
//
//  def f3(i: Int): Option[Int] = {
//    Some(i * 2)
//  }
//
//  def compr(): Unit = {
//
//    val result = for {
//      str1 <- f1()
//      n2 <- f2(str1)
//      n3 <- f3(n2)
//    } yield {
//      n3 + 3
//    }
//    println(result)
//  }
//
//  compr()
//
//}

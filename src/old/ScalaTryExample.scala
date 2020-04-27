//import scala.util.{Failure, Success, Try}
//
//object ScalaTryExample extends App {
//
//  val result = getResource("https://httpbin.org/uuid1")
//  result match {
//    case Success(response) => println(s"Result > $response")
//    case Failure(e) => println(s"Error! ${e.getMessage}")
//  }
//
//  def getResource(url : String) : Try[String] = {
//    Try {
//      scala.io.Source.fromURL(url).mkString
//    }
//  }
//}
//

//import scala.concurrent.ExecutionContext.Implicits.global
//import scala.concurrent.Future
//import scala.util.{Failure, Success}
//
//object FutureTest extends App{
//
//  run()
//  while(true){}
//
//
//  def run(): Unit ={
//    val f1 = Future {
//      scala.io.Source.fromURL("https://httpbin.org/uuid1").mkString
//    }
//
//    //way 1
//    f1 onComplete {
//      case Success(result) => println(s"Successful! \n ${result}")
//      case Failure(e) => println(s"Error ${e.getMessage}")
//    }
//
//    //separated
//    f1 onSuccess {
//      case x : String => println(x)
//    }
//
//    f1 onFailure {
//      case e : Exception => println(s"Error ${e.getMessage}")
//    }
//  }
//
//}
//import scala.concurrent.duration.Duration
//import scala.concurrent.{Await, Future}
//import scala.concurrent.ExecutionContext.Implicits.global
//
//
//object Prog1 {
//  def taskA(): Future[Int] = Future {
//    debug("Starting taskA")
//    Thread.sleep(1000) // wait 1secs
//    debug("Finished taskA")
//    2
//  }
//
//  def taskB(): Future[Int] = Future {
//    debug("Starting taskB")
//    Thread.sleep(2000) // wait 2secs
//    debug("Finished taskB")
//    12
//  }
//
//  def taskC(): Future[Int] = Future {
//    debug("Starting taskB")
//    Thread.sleep(2000) // wait 2secs
//    debug("Finished taskB")
//    12
//  }
//
//  def main(args: Array[String]): Unit = {
//    debug("Starting Main")
//    val futureA = taskA()
//    val futureB = taskB()
//    val futureC = taskC()
//    debug("Continuing Main")
//    // wait for both future to complete before exiting
//    val result = Await.result(futureA zip futureB zip futureC, Duration.Inf)
//    val result2 = Await.result(futureA zip futureB zip futureC, Duration.Inf)
//    println(result)
//    println(result2)
//
//
//  }
//  // ...
//
//  def debug(message: String): Unit = {
//    val now = java.time.format.DateTimeFormatter.ISO_INSTANT
//      .format(java.time.Instant.now)
//      .substring(11, 23) // keep only time component
//    val thread = Thread.currentThread.getName()
//    println(s"$now [$thread] $message")
//  }
//}
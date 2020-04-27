//object Prog2 {
//  def taskA(): Unit = {
//    debug("Starting taskA")
//    Thread.sleep(1000) // wait 1secs
//    debug("Finished taskA")
//  }
//
//  def taskB(): Unit = {
//    debug("Starting taskB")
//    Thread.sleep(2000) // wait 2secs
//    debug("Finished taskB")
//  }
//
//  def main(args: Array[String]): Unit = {
//    debug("Starting Main")
//    taskA()
//    taskB()
//    debug("Finished Main")
//  }
//
//  def debug(message: String): Unit = {
//    val now = java.time.format.DateTimeFormatter.ISO_INSTANT
//      .format(java.time.Instant.now)
//      .substring(11, 23) // keep only time component
//    val thread = Thread.currentThread.getName()
//    println(s"$now [$thread] $message")
//  }
//}
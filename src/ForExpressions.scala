import scala.concurrent.Future
import scala.util.{Failure, Success}
import scala.concurrent.ExecutionContext.Implicits.global

object ForExpressions extends App {
  val nums = Seq(1, 2, 3)

  val doubledNums = for (n <- nums) yield n * 2
  println(doubledNums)

  val names = List("adam", "david", "frank")
  val ucNames = for (name <- names) yield name.capitalize
  println(ucNames)

  val names1 = List("_adam", "_david", "_frank")
  val capNames = for (name <- names1) yield {
    val nameWithoutUnderscore = name.drop(1)
    val capName = nameWithoutUnderscore.capitalize
    capName
  }
  println(capNames)
  for (name <- names) yield name.drop(1).capitalize
  for (name <- names) yield {
    name.drop(1).capitalize
  }

  //With options

  val someNum1 = Some(1)
  val someNum2 = Some(3)
  val someNum3 = Some(5)

  val addition = for {
    num1 <- someNum1
    num2 <- someNum2
    num3 <- someNum3
  } yield num1 + num2 + num3
  println(addition)

  //with Futures
  // (a) create the futures
  val f1 = Future {
    sleep(800); 1
  }
  val f2 = Future {
    sleep(200); 2
  }
  val f3 = Future {
    sleep(400); 3
  }

  // (b) run them simultaneously in a for-comprehension
  val result = for {
    r1 <- f1
    r2 <- f2
    r3 <- f3
  } yield r1 + r2 + r3

  // (c) do whatever you need to do with the result
  result.onComplete {
    case Success(x) => println(s"\nresult = $x")
    case Failure(e) => println(e)
  }

  // important for a little parallel demo: keep the jvm alive
  sleep(3000)

  def sleep(time: Long): Unit = Thread.sleep(time)
}

//import java.util.Date
//
//object ImplicitFunctionTest extends App{
//  val date = new Date()
//  f1(date)
//
//  def f1(timeStamp : Long): Unit ={
//    println(s"Timestamp : $timeStamp")
//  }
//
//  def f2(date: Date): Unit = {
//    println("dfdf")
//  }
//
//  implicit def x(y: Date) : Long = {
//    y.getTime
//  }
//
//  f2(date)
//}
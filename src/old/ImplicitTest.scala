//object ImplicitTest extends App{
//  import PrinterPool._
//  val book = Book("Harry potter","1SSS2-243FDB")
//  book.print()
//}
//
//case class Book(name : String, isbn : String)
//
//object PrinterPool {
//  implicit class Printer(book : Book) {
//    def print(): Unit ={
//      println("==========================")
//      println(s"Book Name : ${book.name}")
//      println(s"Book ISBN : ${book.isbn}")
//      println("==========================")
//    }
//  }
//}
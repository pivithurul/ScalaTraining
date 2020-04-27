//import java.io.{FileNotFoundException, FileOutputStream, IOException}
//
//import scala.util.control.NonFatal
//
//class ExceptionHandling {
//
//}
//
//object ExHandling extends App {
//
//  def handleFile (): Unit ={
//    try {
//      val file = new FileOutputStream("/file.dat")
//      file.write(Array[Byte](12,34,23,53))
//      file.close()
//    }catch {
//      case e : FileNotFoundException => println(s"Could not open file!!\t ${e.getMessage}")
//      case e : IOException => println(s"Error!\t ${e.getMessage}")
//      case NonFatal(e) => println(s"Unknown Error'\t${e.getMessage}")
//    }
//    finally {
//      //do something
//    }
//  }
//
//  handleFile()
//
//}

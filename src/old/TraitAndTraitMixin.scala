//trait Fruit {
//  val colour : String
//
//  def printColour(): Unit ={
//    println(colour)
//  }
//
//  def isApplicableLength : Boolean = true
//}
//
//trait StoreItem{
//  def isApplicableLength : Boolean = false
//
//  def isApplicableWeight : Boolean
//}
//
//class Apple (weight : Int, col : String) extends Fruit with StoreItem {
//  override val colour = col
//
//  override def isApplicableLength: Boolean = true
//
//  override def isApplicableWeight: Boolean = weight > 120
//}
//
//class Banana(length : Int, col : String) extends StoreItem with Fruit {
//  override val colour = col
//
//  override def isApplicableLength: Boolean = length > 5
//
//  override def isApplicableWeight: Boolean = true
//}
//
//object Main2 extends App{
//  val apple = new Apple(120,"RED")
//  val ban1 = new Banana(10,"GREEN")
//  apple.printColour()
//  println(apple.isApplicableWeight)
//
//  ban1.printColour()
//  println(ban1.isApplicableLength)
//}

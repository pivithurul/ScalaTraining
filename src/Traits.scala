import scala.collection.mutable.ArrayBuffer

trait Traits

trait Vehicle

trait TwoWheelVehicle

abstract class MotorBike

class Ct100 extends MotorBike with Vehicle

//class Discover extends Vehicle with MotorBike

//----------------------------------------------------
trait Greeting {
  def greet()
}

abstract class Welcome {
  def welcome()
}

class MyClass extends Welcome {
  def welcome() {
    println("Welcome")
  }
}

object Example1 extends App {
  var m = new MyClass() with Greeting {
    override def greet(): Unit = {
      println("Hello")
    }
  }
  m.greet()
  m.welcome()
}

//--------------------------------------------------------------
//SubTyping
trait Pet {
  val name: String
}

class Parrot(val name: String) extends Pet

class Rabbit(val name: String) extends Pet

object Example2 extends App {
  val parrot = new Parrot("Harry")
  val rabbit = new Rabbit("Sally")

  val animals = ArrayBuffer[Pet]()
  animals.append(parrot)
  animals.append(rabbit)
  animals.foreach(pet => println(pet.name))
}

//--------------------------------------------------------------
trait Iterator[A] {
  def hasNext: Boolean

  def next(): A
}

class IntIterator(to: Int) extends Iterator[Int] {
  private var current = 0

  override def hasNext: Boolean = current < to

  override def next(): Int = {
    if (hasNext) {
      val t = current
      current += 1
      t
    } else 0
  }
}

object Example3 extends App {
  val iterator = new IntIterator(10)

  while (iterator.hasNext) {
    println(iterator.next())
  }
}


//-----------------------------------------------------
/*trait API {
  def createNew: Robot

  type Robot <: RobotOps // note 1

  trait RobotOps {
    def battle(other: Robot): Boolean
  }

}

trait User extends API {
  def run: Boolean = createNew battle createNew // note 2
}

trait Impl extends API {
  def createNew = new Robot(scala.util.Random.nextDouble)

  class Robot(val strength: Double) extends RobotOps {
    def battle(other: Robot): Boolean = strength > other.strength // note 3
  }

}

object Main extends App with User with Impl {
  println(run)
}*/


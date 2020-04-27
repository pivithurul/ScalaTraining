object Generics extends App {

  //Defining a generic class
  class Stack[A] {
    private var elements: List[A] = Nil

    def push(x: A) {
      elements = x :: elements
    }

    def peek: A = elements.head

    def pop(): A = {
      val currentTop = peek
      elements = elements.tail
      currentTop
    }
  }

  //Usage
  val stack = new Stack[Int]
  stack.push(1)
  stack.push(2)
  println(stack.pop)  // prints 2
  println(stack.pop)  // prints 1


  // if the type argument had subtypes, those could be passed in

  class Fruit
  class Apple extends Fruit
  class Banana extends Fruit

  val stack1 = new Stack[Fruit]
  val apple = new Apple
  val banana = new Banana

  stack1.push(apple)
  stack1.push(banana)

  //--------------------------------------------------------------------
  abstract class Animal {
    def name: String
  }

  abstract class Pet extends Animal {}

  class Cat extends Pet {
    override def name: String = "Cat"
  }

  class Dog extends Pet {
    override def name: String = "Dog"
  }

  class Lion extends Animal {
    override def name: String = "Lion"
  }

  class PetContainer[P <: Pet](p: P) {
    def pet: P = p
  }

  val dogContainer = new PetContainer[Dog](new Dog)
  val catContainer = new PetContainer[Cat](new Cat)
//  val lionContainer = new PetContainer[Lion](new Lion)
}

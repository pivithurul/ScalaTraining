object LazyVal {
  lazy val foo = {
    println("Initializing")
    "my foo value"
  }

  val bar = {
    println("Initializing bar")
    "my bar value"
  }

  //Initialization is computationally expensive and usage of val is rare.
  lazy val tiresomeValue = {(1 to 1000000).filter(x => x % 113 == 0).sum}
  if (scala.util.Random.nextInt > 1000) {
    println(tiresomeValue)
  }
  //tiresomeValue takes a long time to calculate, and it's not always used. Making it a lazy val saves unnecessary computation.

}

//Resolving cyclic dependencies
object comicBook {
  def main(args:Array[String]): Unit = {
    gotham.hero.talk()
    gotham.villain.talk()
  }
}

class Superhero(val name: String) {
  lazy val toLockUp = gotham.villain
  def talk(): Unit = {
    println(s"I won't let you win ${toLockUp.name}!")
  }
}

class Supervillain(val name: String) {
  lazy val toKill = gotham.hero
  def talk(): Unit = {
    println(s"Let me loosen up Gotham a little bit ${toKill.name}!")
  }
}

object gotham {
  val hero: Superhero = new Superhero("Batman")
  val villain: Supervillain = new Supervillain("Joker")
}




object PatternMatching extends App {
  //Simple pattern matching

  def matchTest(x: Int): String = x match {
    case 1 => "one"
    case 2 => "two"
    case _ => "other"
  }

  println(matchTest(3)) // other
  println(matchTest(1)) // one


  //With case classes
  case class Person(name: String, age: Int)

  val alice = new Person("Alice", 25)
  val bob = new Person("Bob", 32)
  val charlie = new Person("Charlie", 32)

  for (person <- List(alice, bob, charlie)) {
    person match {
      case Person("Alice", 25) => println("Hi Alice!")
      case Person("Bob", 32) => println("Hi Bob!")
      case Person(name, age) => println(
        "Age: " + age + " year, name: " + name + "?")
    }
  }


  abstract class Notification

  case class Email(sender: String, title: String, body: String) extends Notification

  case class SMS(caller: String, message: String) extends Notification

  case class VoiceRecording(contactName: String, link: String) extends Notification


  def showNotification(notification: Notification): String = {
    notification match {
      case Email(sender, title, _) =>
        s"You got an email from $sender with title: $title"
      case SMS(number, message) =>
        s"You got an SMS from $number! Message: $message"
      case VoiceRecording(name, link) =>
        s"You received a Voice Recording from $name! Click the link to hear it: $link"
    }
  }

  //  val someSms = SMS("12345", "Are you there?")
  //  val someVoiceRecording = VoiceRecording("Tom", "voicerecording.org/id/123")
  //
  //  println(showNotification(someSms))  // prints You got an SMS from 12345! Message: Are you there?
  //
  //  println(showNotification(someVoiceRecording))  // you received a Voice Recording from Tom! Click the link to hear it: voicerecording.org/id/123


  def showImportantNotification(notification: Notification, importantPeopleInfo: Seq[String]): String = {
    notification match {
      case Email(sender, _, _) if importantPeopleInfo.contains(sender) =>
        "You got an email from special someone!"
      case SMS(number, _) if importantPeopleInfo.contains(number) =>
        "You got an SMS from special someone!"
      case other =>
        showNotification(other) // nothing special, delegate to our original showNotification function
    }
  }

  val importantPeopleInfo = Seq("867-5309", "jenny@gmail.com")

  val someSms = SMS("123-4567", "Are you there?")
  val someVoiceRecording = VoiceRecording("Tom", "voicerecording.org/id/123")
  val importantEmail = Email("jenny@gmail.com", "Drinks tonight?", "I'm free after 5!")
  val importantSms = SMS("867-5309", "I'm here! Where are you?")

  println(showImportantNotification(someSms, importantPeopleInfo)) //prints You got an SMS from 123-4567! Message: Are you there?
  println(showImportantNotification(someVoiceRecording, importantPeopleInfo)) //prints You received a Voice Recording from Tom! Click the link to hear it: voicerecording.org/id/123
  println(showImportantNotification(importantEmail, importantPeopleInfo)) //prints You got an email from special someone!

  println(showImportantNotification(importantSms, importantPeopleInfo)) //prints You got an SMS from special someone!

  //---------------------------------------------------------------------------------------------------------------------
  abstract class Animal

  case class Mammal(name: String, fromSea: Boolean) extends Animal

  case class Bird(name: String) extends Animal

  case class Fish(name: String) extends Animal

  def caseClassesPatternMatching(animal: Animal): String = {
    animal match {
      case Mammal(name, fromSea) => s"I'm a $name, a kind of mammal. Am I from the sea? $fromSea"
      case Bird(name) => s"I'm a $name, a kind of bird"
      case _ => "I'm an unknown animal"
    }
  }

  //Constants
  def constantsPatternMatching(constant: Any): String = {
    constant match {
      case 0 => "I'm equal to zero"
      case 4.5d => "I'm a double"
      case false => "I'm the contrary of true"
      case _ => s"I'm unknown and equal to $constant"
    }
  }

  //Sequences
  def sequencesPatternMatching(sequence: Any): String = {
    sequence match {
      case List(singleElement) => s"I'm a list with one element: $singleElement"
      case List(_, _*) => s"I'm a list with one or multiple elements: sequence"
      case Vector(1, 2, _*) => s"I'm a vector: $sequence"
      case _ => s"I'm an unrecognized sequence. My value: $sequence"
    }
  }

  //Tuples
  def tuplesPatternMatching(tuple: Any): String = {
    tuple match {
      case (first, second) => s"I'm a tuple with two elements: $first & $second"
      case (first, second, third) => s"I'm a tuple with three elements: $first & $second & $third"
      case _ => s"Unrecognized pattern. My value: $tuple"
    }
  }

  //More examples
  def morePatternMatchingWithSequences(ints: Seq[Int]): String = ints match {
    case Seq() =>
      "The Seq is empty !"
    case Seq(first) =>
      s"The seq has exactly one element : $first"
    case Seq(first, second) =>
      s"The seq has exactly two elements : $first, $second"
    case s@Seq(_, _, _) =>
      s"s is a Seq of length three and looks like ${s}" // Note individual elements are not bound to their own names.
    case s: Seq[Int] if s.length == 4 =>
      s"s is a Seq of Ints of exactly length 4" // Again, individual elements are not bound to their own names.
    case _ =>
      "No match was found!"
  }

  def f(ints: Seq[Int]): String = ints match {
    case Seq(first, second, tail @ _*) =>
      s"The seq has at least two elements : $first, $second. The rest of the Seq is $tail"
    case Seq(first, tail @ _*) =>
      s"The seq has at least one element : $first. The rest of the Seq is $tail"
    case _ =>
      "The seq didn't match any of the above, so it must be empty"
  }

  //Typed patterns
  def typedPatternMatching(any: Any): String = {
    any match {
      case string: String => s"I'm a string. My value: $string"
      case integer: Int => s"I'm an integer. My value: $integer"
      case _ => s"I'm from an unknown type. My value: $any"
    }
  }

  //Regex patterns
  def regexPatterns(toMatch: String): String = {
    val numeric = """([0-9]+)""".r
    val alphabetic = """([a-zA-Z]+)""".r
    val alphanumeric = """([a-zA-Z0-9]+)""".r

    toMatch match {
      case numeric(value) => s"I'm a numeric with value $value"
      case alphabetic(value) => s"I'm an alphabetic with value $value"
      case alphanumeric(value) => s"I'm an alphanumeric with value $value"
      case _ => s"I contain other characters than alphanumerics. My value $toMatch"
    }
  }

  //Options: Some<T> and None
  def optionsPatternMatching(option: Option[String]): String = {
    option match {
      case Some(value) => s"I'm not an empty option. Value $value"
      case None => "I'm an empty option"
    }
  }

  //Pattern Guards
  def patternGuards(toMatch: Any, maxLength: Int): String = {
    toMatch match {
      case list: List[Any] if (list.size <= maxLength) => "List is of acceptable size"
      case list: List[Any] => "List has not an acceptable size"
      case string: String if (string.length <= maxLength) => "String is of acceptable size"
      case string: String => "String has not an acceptable size"
      case _ => "Input is neither a List nor a String"
    }
  }

  //Matching on type only
  abstract class Device

  case class Phone(model: String) extends Device {
    def screenOff = "Turning screen off"
  }

  case class Computer(model: String) extends Device {
    def screenSaverOn = "Turning screen saver on..."
  }

  def goIdle(device: Device) = device match {
    case p: Phone => p.screenOff
    case c: Computer => c.screenSaverOn
  }

  //Extractors
  object Doctor {
    def apply(fullName: String) = fullName

    def unapply(fullName: String): Option[String] = {
      if (!fullName.isEmpty)
        Some(fullName.replaceAll("(?<=\\w)(\\w+)", "."))
      else
        None
    }
  }

  def extractors(doctor: Any): String = {
    doctor match {
      case Doctor(initials) => s"My initials are $initials"
      case _ => "Could not extract initials"
    }
  }
  val doctor = Doctor("John Smith")
  println(extractors(doctor))

  //Sealed classes (all subtypes must be declared in the same file)
  sealed abstract class Furniture

  case class Couch() extends Furniture

  case class Chair() extends Furniture

  def findPlaceToSit(piece: Furniture): String = piece match {
    case Couch() => "Lie on the couch"
    case Chair() => "Sit on the chair"
  }

}

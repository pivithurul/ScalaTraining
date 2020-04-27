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


  //Sealed classes (all subtypes must be declared in the same file)
  sealed abstract class Furniture
  case class Couch() extends Furniture
  case class Chair() extends Furniture

  def findPlaceToSit(piece: Furniture): String = piece match {
    case Couch() => "Lie on the couch"
    case Chair() => "Sit on the chair"
  }

}

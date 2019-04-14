import java.util
import scala.io.Source

class customer(name:String, lastName:String, number: String, gender: String){
  def get_name:String= name
  def get_lastName:String= lastName
  def get_fullName:String= name + "" + lastName
  def get_number: String= number
  def get_gender: String= gender
  override def toString: String= {
    "customer name: " + name+"\n customer last name: "+ lastName+"\n customer full name: "+ this.get_fullName+ "\n customer number: " + number+  "\n customer gender: " + gender
  }
}


class contactBook(path: String, namePointer: Int, lastNamePointer: Int, numberPointer:Int, genderPointer: Int, separator: String) {
  var contacts= new util.ArrayList[customer]

  val buffer = Source.fromFile(path)
  for (line <- buffer.getLines.drop(1)) {
    val cols = line.split(separator).map(_.trim)
    val cust = new customer(cols(namePointer), cols(lastNamePointer), cols(numberPointer), cols(genderPointer))
    contacts.add(cust)
  }
  buffer.close


  def add(customer: customer): Unit = contacts.add(customer)
  def remove(index: Int): Unit = contacts.remove(index)
  def get(index: Int): Unit = contacts.get(index)

  def get_cont_by_gender(gender: String): contactBook={
    var contGender = this
    for(contact<-0 to contacts.size()){
      if(contacts.get(contact).get_gender!= gender) contGender.remove(contact)
    }
    contGender
  }

  def show(): Unit = {
    for (a: Int <- 0 until contacts.size()) println(contacts.get(a).toString)
  }
}

class message(path: String, gender: String) {
  val buffer = Source.fromFile(path)
  val msg: String = buffer.getLines.mkString
  buffer.close
  def get_message: String = msg
  def get_gender: String = gender
  override def toString: String = {
    "message: " + msg + "\n from path: " + path + "\n gender: " + gender
  }

}

class messageBook(){
  val messages = new util.ArrayList[message]
  def add(message: message): Unit= messages.add(message)
  def remove(index: Int): Unit = messages.remove(index)
  def get(index: Int): message = messages.get(index)

  def get_msg_by_gender(gender:String):message={
    var store: Int =0
    for(message<-0 until messages.size()){
      if(messages.get(message).get_gender== gender) store= message
    }
    messages.get(store)
  }

}

class sender(APIkey: String, APIsecret: String) {
  def get_APIkey: String = APIkey
  def get_APIsecret: String = APIsecret

  def send_message(recipients: contactBook, message: message):Unit={
    for(contact<- 0 until recipients.contacts.size()){
      //Incollare qui l'api del fornitore e puntare a recipients.contacts.get(contact)
      recipients.contacts.get(contact)
      message.get_message
    }
  }

  def send_message_gender(recipients: contactBook, messages: messageBook, gender: String): Unit ={
    val msgGender: message= messages.get_msg_by_gender(gender)
    val contGender: contactBook = recipients.get_cont_by_gender(gender)
    send_message(contGender,msgGender)
  }
}

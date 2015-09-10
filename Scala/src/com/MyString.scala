/**
 * Created by vdudi on 9/3/15.
 */

import java.lang.Character
import scala.runtime.RichChar

trait MyStringInterface {
  def setString(string: String)
  def getString(): String
  def getConsonants() : String
  def numberOfConsonants(): Int
  @throws(classOf[IllegalIndexException])
  @throws(classOf[IllegalArgumentException])
  def getCharacter(position: Int): Char
  @throws(classOf[IllegalIndexException])
  @throws(classOf[IllegalArgumentException])
  def flipCaseInSubstring(startPosition: Int, endPosition: Int): String

}

class MyString extends MyStringInterface {
  var myString: String = null

  def setString(str: String): Unit = {
    myString = str
  }

  def getString(): String ={
    return myString
  }

  def getConsonants(): String ={

    val ovel_Array = Array('a','e','i','o','u',' ','A','E','I','O','U')

    println("Ovels: "+ovel_Array.mkString)

    return  myString.filterNot(ovel_Array.contains(_))

  }

  def numberOfConsonants(): Int ={
    return  getConsonants().size
  }

  @throws(classOf[IllegalIndexException])
  @throws(classOf[IllegalArgumentException])
  def getCharacter(position: Int): Char ={
    return myString.charAt(position)
  }


  @throws(classOf[IllegalIndexException])
  @throws(classOf[IllegalArgumentException])
  def flipCaseInSubstring(startPosition: Int, endPosition: Int): String ={
    if(startPosition < 0 &&  endPosition <=0 && endPosition < startPosition){
      throw new IllegalArgumentException()
    }
    if(endPosition > myString.length){
      throw new IllegalIndexException()
    }
    var str = myString.substring(startPosition,endPosition).toCharArray
    println("Sub string b4 case change: "+str.mkString)
    for(char<-str){
      if(char.isLower) {
        str.update(str.indexOf(char),char.toUpper)
        //str(str.indexOf(char)) =char.toUpper
      }
      if(char.isUpper) {
        str.update(str.indexOf(char),char.toLower)
        }
    }

    return str.mkString
  }


}

object MyStringTest {
  def main(args:Array[String]): Unit = {
    val str = "I love scala"
    val test  = new MyString;
    test.setString(str)
    System.err.println("Original string: "+str)
    System.err.println("Original string length: "+str.length)
    System.err.println("Get Consonants: "+test.getConsonants())
    System.err.println("NumberOfConsonants: "+test.numberOfConsonants())
    System.err.println("flipCaseInSubstring: "+test.flipCaseInSubstring(0,13))

  }

}
/**
 * Created by vdudi on 7/15/15.
 */
object ForAndYield {
  def main(args:Array[String]): Unit = {
    val res = for(a<-args) yield a.toUpperCase
    println("Agrs: "+res.toString)

    println("Agrs: "+args.mkString)
  }

  def squre(x: Int): Int = x * x
  def sumofSquares(a: Int, b: Int) : Int =
  if(a > b) 0 else squre(a)+sumofSquares(a+1,b)






}

object Maps {
  val colors = Map("red"->123, "black"->234, "orange"->345, "brown"->456)

  def main(args:Array[String]): Unit ={

    val states = Map("AL"-> "Alabama", "AK"->"Alaska","FL"->"Florida")
    val states1 = Map("GA"-> "Georgia", "CA"->"California","FL"->"Florida")
    //states =+("MI"->"Mileee")

    for((k,v)<- states) printf("Key: %s, Value: %s\n", k, v)

    for(x<-states1) println("Key: "+ x._1 +", Value: "+ x._2)
    var similar =""
    states.keys.foreach( (key)=>if(states1.contains(key)) similar += (key, (states1.get(key))))
    println("similar: "+ similar)


    def h(k: String, v: String) = {
      if(states1.contains(k)) Some(k->v) else None
    }
    //println(states.flatMap((kv) => if(kv._1 == states1.contains(kv._1))(kv._1,kv._2)))
    println(states.flatMap(e => List(e)))
    println(states.flatMap(e => h(e._1, e._2)))
    println(states.map(e => h(e._1, e._2)))



//    for(name<-args) println(
//      colors.get(name) match{
//        case Some(cod) => name + " has code:" + cod
//        case None => "Unknown color:" + name
//      }
//
//    )
  }
}
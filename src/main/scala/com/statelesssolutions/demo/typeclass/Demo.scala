package com.statelesssolutions.demo.typeclass

import java.io._

object Demo {

  def main(args: Array[String]) = {

/*    val generators:Map[String,HasNextInt] = Map(
      "sequence" -> new SequentialGenerator(),
      "positive random" -> new PositiveRandomGenerator(),
      "meaning of life" -> new MeaningOfLifeGenerator(),
      "util.Random" -> new util.Random()
    )

    generators.foreach(kv => {
      println(kv._1 + " - next 10 ints --- ")
      println((1 to 10).map(i => kv._2.nextInt).mkString(", "))
    })*/
    println("sequence")
    printIt(new SequentialGenerator())
    println("positive random")
    printIt(new PositiveRandomGenerator())
    println("meaning of life")
    printIt(new MeaningOfLifeGenerator())
    println("util.random")
    printIt(new util.Random())
  }

  type HasNextInt = {
    def nextInt(): Int
  }

  def printIt(gen: HasNextInt) = 
    println((1 to 10).map(i => gen.nextInt).mkString(","))
}

class SequentialGenerator {
  val counter = (1 to Int.MaxValue).iterator
  def nextInt(): Int = counter.next
}

class PositiveRandomGenerator {
  val r = new util.Random
  def nextInt(): Int = r.nextInt.abs
}

class MeaningOfLifeGenerator {
  def nextInt(): Int = 42
}

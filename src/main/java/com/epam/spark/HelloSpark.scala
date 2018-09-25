package com.epam.spark

import java.util.Scanner

import org.apache.spark.{SparkConf, SparkContext}

object HelloSpark {
  def main(args: Array[String]): Unit = {

    val conf = new SparkConf()
      .setAppName("HelloSpark")
      .setMaster("local[*]")

    val sc = new SparkContext(conf)

    println("Hello, SparkWorld!")
//    val rdd1 = sc.parallelize(1 to 10)
//    val rdd2 = sc.parallelize(20 to 30)
//    val rdd3 = rdd1.union(rdd2)
//    val rdd4 = rdd2.union(rdd2).union(rdd1)
    val rdd5 = sc.parallelize(
      TestText.getRandomText(1000)
        .replace(",", "")
        .replace(".", "")
        .replace("?", "")
        .toLowerCase()
        .split(" ")
    )

//    val ints = rdd3.collect()
    //    print(ints.toString)
    //    println(util.Arrays.toString(ints))
    //    println(rdd3.count())
    //    println(rdd4.countByValue())
    rdd5.countByValue()
      .toStream
      .sortBy(_2 => {_2._2})
      .foreach {
        println
      }


//    new Scanner(System.in).next()
    sc.stop()
  }

}

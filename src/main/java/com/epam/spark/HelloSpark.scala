package com.epam.spark

import org.apache.spark.{SparkConf, SparkContext}

object HelloSpark {
  def main(args: Array[String]): Unit = {

    val conf = new SparkConf()
      .setAppName("HelloSpark")
      .setMaster("local[*]")

    val sc = new SparkContext(conf)
    println("Hello, SparkWorld!")


    println("randomTextCreating -> Start")
    val randomText = TestText.getRandomText(10000000)

    println("sc.parallelize -> Start")
    val rdd = sc.parallelize(randomText
      /*        .replace(",", "")
              .replace(".", "")
              .replace("?", "")
              .toLowerCase()*/
      .split(" ")
    )

    println("rdd.countByValue -> Start")
    rdd.countByValue()
      .toStream
      .sortBy(_2 => {
        _2._2
      })
//      .foreach {
//        println()
//      }

    println("All -> Finish")

    sc.stop()
  }

}

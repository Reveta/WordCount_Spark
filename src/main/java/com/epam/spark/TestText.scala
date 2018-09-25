package com.epam.spark

import scala.util.Random

object TestText {
  val alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray
  val random: Random = new Random()

  //  def main(args: Array[String]): Unit = {
  //    println(getRandomText(500))
  //  }

  def getText(): String = "Hadoop Questions and Answers has been designed with a special intention of helping students and professionals preparing for various Certification Exams and Job Interviews. This section provides a useful collection of sample Interview Questions and Multiple Choice Questions (MCQs) and their answers with appropriate explanations. Question/Answers Type Hadoop Interview Questions This section provides a huge collection of Hadoop Interview Questions with their answers hidden in a box to challenge you to have a go at them before discovering the correct answer. Hadoop Online Quiz This section provides a great collection of Hadoop Multiple Choice Questions (MCQs) on a single page along with their correct answers and explanation. If you select the right option, it turns green; else red. Hadoop Online Test If you are preparing to appear for a Java and Hadoop Framework related certification exam, then this section is a must for you. This section simulates a real online test along with a given timer which challenges you to complete the test within a given time-frame. Finally you can check your overall test score and how you fared among millions of other candidates who attended this online test. Hadoop Mock Test This section provides various mock tests that you can download at your local machine and solve offline. Every mock test is supplied with a mock test key to let you verify the final score and grade yourself."

  def getRandomText(size: Int): String = {

    val newBuilder: StringBuilder = new StringBuilder

    for (a <- 0 to size) {
      newBuilder.append(getRandomWord())
    }

    return newBuilder.toString()
  }


  private def getRandomWord(): StringBuilder = {

    var newBuilder: StringBuilder = new StringBuilder

    for (a <- 0 to random.nextInt(6)) {
      newBuilder.append(getRandomLetter())
    }

    return newBuilder.append(" ")
  }


  private def getRandomLetter(): Char = alphabet(random.nextInt(alphabet.length - 1))
}

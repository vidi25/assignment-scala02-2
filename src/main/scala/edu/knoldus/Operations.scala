package edu.knoldus

class Operations {

  sealed abstract class Person

  case class Gamer(name: String) extends Person {

    def rollDiceGame(numberOfTimes: Int): String = {
       val start = 1
       val end = 6
       val rnd = new scala.util.Random
      val number = start + rnd.nextInt((end - start) + 1)
      number match {
        case num if num == 1 || num == 6 && numberOfTimes == 3 => s"$name is a winner"
        case num if num == 1 || num == 6 => rollDiceGame(numberOfTimes + 1)
        case _ => s"$name is a looser"
      }
    }

  }

  case class Trainer() extends Person {

    def takeAttendance(): String = {
      val rnd = new scala.util.Random
      s"Attendance = ${1 + rnd.nextInt((50 - 1) + 1)}"
    }

  }

  case class Blogger(blogList: Map[String,Int]) extends Person {

    def updateMap(blogList: Map[String,Int], subject: String): Map[String,Int] = {
      blogList.map(sub => if(sub._1 == subject) (sub._1, sub._2 + 1) else (sub._1,sub._2))
    }

    def writeBlog(blogList: Map[String,Int]): String = {
      def writeBlogRecursive(list: Map[String, Int], noOfTimes: Int): Map[String, Int] = {
          val rnd = new scala.util.Random
          val subjects = list.keySet.toList
          val sub = subjects(rnd.nextInt(subjects.length))
          if (subjects.contains(sub)) {
            val map = updateMap(list, sub)
            writeBlogRecursive(map, noOfTimes + 1)
          }
          else {
            throw new Exception("subject not found")
          }
        }
      val blogList = writeBlogRecursive(blogList,1)
      val favSubject = blogList.maxBy{case (_,blogCount) => blogCount }
      s"Favourite subject is ${favSubject._1}"
    }
  }

  def performOperation(typeOfPerson: Person): String = {
  typeOfPerson match {
    case Gamer(name) => Gamer(name).rollDiceGame(0)
    case Trainer() => Trainer().takeAttendance()
    case Blogger(blogList) => Blogger(blogList).writeBlog(blogList)
    }
  }

}

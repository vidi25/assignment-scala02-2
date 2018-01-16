package edu.knoldus

import org.apache.log4j.Logger

object Application extends App{

  val log = Logger.getLogger(this.getClass)
  val app = new Payment
  val app1 = new Operations

  val paymentMode = "Card"
  val amount = 340

  val InitialMap = Map("java" -> 5, "scala" -> 3, "kafka" -> 2)


  log.info(s"Total amount to be paid = ${app.paymentHandler(amount,paymentMode)}\n")

  log.info(s"${app1.performOperation(app1.Gamer("Aman"))}\n")

  log.info(s"${app1.performOperation(app1.Trainer())}\n")

  log.info(s"${app1.performOperation(app1.Blogger(InitialMap))}")

}

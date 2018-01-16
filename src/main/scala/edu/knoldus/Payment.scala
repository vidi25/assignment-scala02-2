package edu.knoldus

class Payment {

  def paymentHandler(amount: Int, paymentMode: String): Double = {
    paymentMode.toLowerCase match {
      case "paytm"|"freecharge" => amount + (2 * amount/100)
      case "net banking" => amount + 5
      case "card" => amount + 1.5
      case _ => amount
    }
  }

}

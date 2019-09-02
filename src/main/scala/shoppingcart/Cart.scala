package shoppingcart

final case class Cart(order: List[SaleType]) {

    //calculate the subtotal for each item
    val subTotal = for (i <-order) yield i.totalPrice

  //sum across the list of subtotals
    def orderTotal(list: List[Double]): Double = list match {
      case Nil => 0
      case head :: tail => head + orderTotal(tail)
    }

    //print order total
  def printTotal() {
    //print the subtotal for each item
    println("Subtotal:")
    for (i <- order) println(i.totalPrice)

    println("Order Total: " + "%.2f".format(orderTotal(subTotal)).toDouble)
  }
}


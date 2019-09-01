package shoppingcart

final case class Cart(order: List[SaleType]) {

    //calculate the subtotal for each item
    val subTotal = for (i <-order) yield i.totalPrice

    //print the subtotal for each item
    println("Subtotal:")
    for (i <- order) println(i.totalPrice)

    //sum across the list of subtotals
    def orderTotal(list: List[Double]): Double = list match {
      case Nil => 0
      case head :: tail => head + orderTotal(tail)
    }

    //print order total
    println("Order Total: " + orderTotal(subTotal))


}


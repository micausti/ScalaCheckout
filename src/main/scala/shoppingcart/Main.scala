package shoppingcart

import scala.io.StdIn.readLine

object Main extends App {

    //update price list as needed
    final case class PriceList() {
        //unit prices
        val unitPriceA = .50
        val unitPriceB = .30
        val unitPriceC = .20
        val unitPriceD = .15

        //volume required for discount
        val volumeRequiredA = 3
        val volumeRequiredB = 2

        //discount prices
        val discountPriceA = 1.30
        val discountPriceB = .45
    }


    //ask the user what items they want to buy
    val cartInput: String = readLine("Which items do you want to buy? Choose from A, B, C, D... ").toUpperCase()

    //order list which contains a new object for each available sale item, using the correct saleType class (e.g. regular price or volume discount)
    val order = List(new VolumeDiscount(cartInput.count(_ == 'A'), PriceList().unitPriceA, PriceList().volumeRequiredA, PriceList().discountPriceA),
        new VolumeDiscount(cartInput.count(_ == 'B'), PriceList().unitPriceB, PriceList().volumeRequiredB, PriceList().discountPriceB),
        new RegularPrice(cartInput.count(_ == 'C'), PriceList().unitPriceC),
        new RegularPrice(cartInput.count(_ == 'D'), PriceList().unitPriceD))

    //create a new cart object to calculate total
    val cart = new Cart(order)
    cart.printTotal()

}

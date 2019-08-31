package shoppingcart

import scala.io.StdIn.readLine

//try/catch


object Main {
  def main(args: Array[String]): Unit = {


    //Greet the user and ask for a list of items they want to buy
    val cartInput: String = readLine("Which items do you want to buy?").toUpperCase()

    sealed trait SaleType {
      def count: Int

      def unitPrice: Int

      def totalPrice: Float
    }

    final case class RegularPrice(count: Int, unitPrice: Int) extends SaleType {
      //calculate the total price
      def totalPrice(): Float = {
        count * unitPrice
      }
    }

    final case class VolumeDiscount(count: Int, unitPrice: Int, volumeRequired: Int, discountPrice: Int) extends SaleType {
      //how many discounts do we need to apply?
      def discountItems: Int = {
        count / volumeRequired
      }

      //how many single items are there?
      def singletonItems: Int = {
        count - (volumeRequired * (count / volumeRequired))
      }

      def totalPrice(): Float = {
        (discountItems * discountPrice) + (singletonItems * unitPrice)
      }
    }

    val order = List((new VolumeDiscount(cartInput.count(_ == 'A'), 50, 3, 130)),
      (new VolumeDiscount(cartInput.count(_ == 'B'), 30, 2, 45)),
      (new RegularPrice(cartInput.count(_ == 'C'), 20)),
      (new RegularPrice(cartInput.count(_ == 'D'), 15)))

    println("Subtotal")
    for (i <- order) println(i.totalPrice)
    val orderTotal = for (i <-order) yield i.totalPrice
    def sum(list: List[Float]): Float = list match {
      case Nil => 0
      case head :: tail => head + sum(tail)
    }

    println("Order Total Is:", sum(orderTotal))


    }
}



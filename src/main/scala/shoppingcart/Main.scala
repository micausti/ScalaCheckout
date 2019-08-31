package shoppingcart

import scala.io.StdIn.readLine

//try/catch


object Main {
  def main(args: Array[String]): Unit = {

    //Greet the user and ask for a list of items they want to buy
    val cartInput: String = readLine("Which items do you want to buy?").toUpperCase()

    //count how many of each item there are
    val countA = cartInput.count(_ == 'A')
    val countB = cartInput.count(_ == 'B')
    val countC = cartInput.count(_ == 'C')
    val countD = cartInput.count(_ == 'D')

    case class Item(count: Int, unitPrice: Int, discountNumber: Int, discountPrice: Int) {
      //how many discounts do we need to apply?
      def discountItems: Int = {
        if (discountNumber > 0) count/discountNumber else 0
      }
      //how many single items are there?
      def singletonItems: Int = {
        if (discountNumber > 0) count - (discountNumber * (count/discountNumber)) else count
      }

      //calculate the bundle price for bulk discounts
      def offerPrice(): Float = {
        discountItems * discountPrice
      }

      //calculate the singleton price where bulk discounts don't apply
      def singletonPrice(): Float = {
        singletonItems * unitPrice
      }

      def totalPrice(): Float = {
        offerPrice + singletonPrice
      }
    }

    //instantiate a new Item for A-D
    val A = new Item(countA, 50, 3, 130)
    val B = new Item(countB, 30, 2, 45)
    val C = new Item(countC, 20, 0,  0)
    val D = new Item(countD,15, 0, 0)

    println("Cart total is = ", A.totalPrice + B.totalPrice + C.totalPrice + D.totalPrice)


    }
}



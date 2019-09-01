package shoppingcart
import scala.math.BigDecimal


  //identifies the possible sale types; if a new discount type is needed, add a new class here with methods needed to calculate the discount
  sealed trait SaleType {
    def count: Int

    def unitPrice: Double

    def totalPrice: Double
  }

  final case class RegularPrice(count: Int, unitPrice: Double) extends SaleType {
    //calculate the total price
    def totalPrice(): Double = {
      "%.2f".format((count * unitPrice)).toDouble
    }
  }

  final case class VolumeDiscount(count: Int, unitPrice: Double, volumeRequired: Int, discountPrice: Double) extends SaleType {
    //how many discounts do we need to apply?
    def discountItems: Int = {
      count / volumeRequired
    }

    //how many single items are charged at full price?
    def fullPriceItems: Int = {
      count - (volumeRequired * (count / volumeRequired))
    }

    def totalPrice(): Double = {
      "%.2f".format((discountItems * discountPrice)+ (fullPriceItems * unitPrice)).toDouble
    }

}

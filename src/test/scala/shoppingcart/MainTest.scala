package shoppingcart

import org.scalatest.FunSuite
import shoppingcart.Main.PriceList

class MainTest extends FunSuite {

  var priceListTest: PriceList = _
  priceListTest = new PriceList
  test("check to make sure no negative or zero values are entered in the configuration") {
    assert(PriceList().unitPriceA > 0)
    assert(PriceList().unitPriceB > 0)
    assert(PriceList().unitPriceC > 0)
    assert(PriceList().unitPriceD > 0)
    assert(PriceList().volumeRequiredA > 0)
    assert(PriceList().volumeRequiredB > 0)
    assert(PriceList().discountPriceA > 0)
    assert(PriceList().discountPriceB > 0)
  }
}

package shoppingcart

import org.scalatest.FunSuite

class RegularPriceTest extends FunSuite {

  var regularPriceTest1: RegularPrice = _
  regularPriceTest1 = new RegularPrice(5, .10)
  test("RegularPrice.totalPrice is the product of count and unit, Test1") {
    assert(regularPriceTest1.totalPrice() == .50)
  }

  var regularPriceTest2: RegularPrice = _
  regularPriceTest2 = new RegularPrice(100, .25)
  test("RegularPrice.totalPrice is the product of count and unit, Test2") {
    assert(regularPriceTest2.totalPrice() == 25.00)
  }

  var regularPriceTest3: RegularPrice = _
  regularPriceTest3 = new RegularPrice(0, .50)
  test("RegularPrice.totalPrice is the product of count and unit, Test3"){
    assert(regularPriceTest3.totalPrice() == 0)
  }
}

class VolumeDiscountPriceTest extends FunSuite {

  var volumeDiscountPriceTest1: VolumeDiscount = _

  volumeDiscountPriceTest1 = new VolumeDiscount(10, .20, 3, .15)

  test("VolumeDiscount.totalPrice is the sum of the discounted items and non-discounted items, Test1") {
    assert(volumeDiscountPriceTest1.totalPrice() == .65)
  }
  test("VolumeDiscount.discountItems is the result of count divided by volume required, cast to an int, Test1") {
    assert(volumeDiscountPriceTest1.discountItems == 3)
  }
  test("VolumeDiscount.fullPriceItems is the remainder of items after discounted items are removed, Test1") {
    assert(volumeDiscountPriceTest1.fullPriceItems == 1)
  }

  var volumeDiscountPriceTest2: VolumeDiscount = _

  volumeDiscountPriceTest2 = new VolumeDiscount(10, .30, 2, .45)

  test("VolumeDiscount.totalPrice is the sum of the discounted items and non-discounted items, Test2") {
    assert(volumeDiscountPriceTest2.totalPrice() == 2.25)
  }
  test("VolumeDiscount.discountItems is the result of count divided by volume required, cast to an int, Test2") {
    assert(volumeDiscountPriceTest2.discountItems == 5)
  }
  test("VolumeDiscount.singletonItems is the remainder of items after discounted items are removed, Test2") {
    assert(volumeDiscountPriceTest2.fullPriceItems == 0)
  }
}




package shoppingcart

import org.scalatest.FunSuite

class CartTest extends FunSuite{
  var cartTest: Cart = _
  cartTest = new Cart(List(new VolumeDiscount(1, 1, 1, 1),
    new VolumeDiscount(1, 1, 1, 1),
    new RegularPrice(1, 1),
    new RegularPrice(1, 1)))
  test("order total should return the sum of the subtotals of all the items in the cart") {
  assert(cartTest.orderTotal(cartTest.subTotal) == 4.0)
  }

  var cartTest2: Cart = _
    cartTest2 = new Cart(List(new VolumeDiscount(100000000, 1, 1, 1),
    new VolumeDiscount(100000, 1, 1, 1),
    new RegularPrice(10000000, 1),
    new RegularPrice(1000000, 1)))
  test("order total should return the sum of the subtotals of all the items in the cart v2") {
    assert(cartTest2.orderTotal(cartTest2.subTotal) == 1.111E8)
  }

  var cartTest3: Cart = _
  cartTest3 = new Cart(List(new VolumeDiscount(0, 2, 3, 1)))
  test("order total should return the sum of the subtotals of all the items in the cart v3") {
    assert(cartTest3.orderTotal(cartTest3.subTotal) == 0)
  }
}

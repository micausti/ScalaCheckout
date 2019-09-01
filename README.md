Welcome to the ScalaCheckout application!

This application asks the user which items they would like to buy, calculates the total cost of the order, and returns it to the user.

To run:
1. Clone the repository to your local machine
2. From the command line, cd to the correct directory
3. sbt run
4. Respond to the prompt 'Which items do you want to buy?'

To make updates:
1. To update the sale price or discount price of an item, see Main.scala. Update the Price List here. **Make sure to run the test configuration before deploying to check for invalid values in the Price List.**
2. To add a new sale item, add a new 'unit price' for that item in Main.scala, then update 'val order' to add a new instance for the correct SaleType (Regular Price or Volume Discount). Update the text prompt in 'val cartInput' to reflect the new sale item list.
3. To add a new discount type, add a new case class in 'SaleType.scala' which contains count, unitPrice, totalPrice, and methods which allow the calculation of the new discount type. Add new vars as needed in Main.scala.
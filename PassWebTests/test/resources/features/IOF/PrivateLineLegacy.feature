@Regression @PrivateLineLegacy @IOF 
Feature: Verify ordering Private Line Legacy product 

@DirectOrder 
Scenario Outline:
Verify that IOF Private Line Legacy direct order can be submitted 
	Given I am logged in as a "Commercial" user in SFA 
	When I submit "<Order_Type>" iof direct order for lite Private Line Legacy product in "QCC" region 
	Then I should see the order status as "Order Submitted" 
	Examples: 
		| Order_Type 				|
		| Add New Services 			|
		| Change Existing Services 	|
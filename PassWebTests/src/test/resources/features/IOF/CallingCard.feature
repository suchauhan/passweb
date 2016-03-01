@Regression @CallingCard @IOF 
Feature: Verify ordering Calling Card product 

@DirectOrder 
Scenario Outline: Verify that IOF Calling Card direct order can be submitted 
	Given I am logged in as a "Commercial" user in SFA 
	When I submit "<Order_Type>" iof direct order for Lite Calling Card product in "QCC" region 
	Then I should see the order status as "Order Submitted" 
	Examples: 
		| Order_Type 				|
		| Add New Services 			|
		| Change Existing Services 	|
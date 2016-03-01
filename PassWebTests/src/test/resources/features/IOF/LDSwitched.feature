@Regression @LDSwitched @IOF 
Feature: Verify ordering LD Switched product 

@DirectOrder 
Scenario Outline: Verify that IOF LD Switched direct order can be submitted 
	Given I am logged in as a "Commercial" user in SFA 
	When I submit "<Order_Type>" iof direct order for Lite LD Switched product in "QCC" region 
	Then I should see the order status as "Order Submitted" 
	Examples: 
		| Order_Type 				|
		| Add New Services 			|
		| Change Existing Services 	|
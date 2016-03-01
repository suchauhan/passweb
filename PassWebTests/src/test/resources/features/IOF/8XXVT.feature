@Regression @8XXVT @IOF 
Feature: Verify ordering 8XX VT product 

@DirectOrder 
Scenario Outline: Verify that IOF 8XX VT direct order can be submitted 
	Given I am logged in as a "Commercial" user in SFA 
	When I submit "<Order_Type>" iof direct order for lite 8XX VT product in "QCC" region 
	Then I should see the order status as "Order Submitted" 
	Examples: 
		| Order_Type 				|
		| Add New Services 			|
		| Change Existing Services 	|
		
@OptyOrder @Sanity
Scenario Outline: Verify that IOF 8XX VT opty order can be submitted 
	Given I am logged in as a "Commercial" user in SFA 
	When I submit "<Order_Type>" iof opty order for lite 8XX VT product in "QCC" region 
	Then I should see the order status as "Order Submitted" 
	Examples: 
		| Order_Type 				|
		| Add New Services 			|
		| Change Existing Services 	|
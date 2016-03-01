@Regression @E911 @OMS 
Feature: Verify ordering E911 product 

@DirectOrder @Sanity @E9111
Scenario Outline: Verify that OMS E911 direct order can be submitted 
	Given I am logged in as a "Commercial" user in SFA 
	When I submit "<order_type>" OMS direct order for lite E911 product in "QC" region 
	Then I should see the order status as "Order Submitted" 
	Examples: 
		| order_type				|
		| New Connect				|
		| Change Existing Service	|

@DirectOrder @Sanity @E9112
Scenario Outline: Verify that OMS E911 direct order can be submitted 
	Given I am logged in as a "Commercial" user in SFA
	When I submit "<order_type>" OMS direct order for lite E911 product in "QC" region with "POTS/RCF" and "Default" form 
	Then I should see the order status as "Order Submitted" 
	Examples: 
		| order_type				|
		| New Connect				|
		| Change Existing Service	| 		 
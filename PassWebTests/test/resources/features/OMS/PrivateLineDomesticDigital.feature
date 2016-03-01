@Regression @PrivateLineDomesticDigital @OMS 
Feature: Verify ordering Private Line Domestic Digital product 

@DirectOrder @Sanity
Scenario Outline: Verify that OMS Private Line Domestic Digital direct order can be submitted 
	Given I am logged in as a "Commercial" user in SFA 
	When I submit "<order_type>" OMS direct order for lite Private Line Domestic Digital product in "QC" region 
	Then I should see the order status as "Order Submitted" 
	Examples: 
		| order_type				|
		| New Connect				|
		| Change Existing Service	|

@DirectOrder @Sanity @E9112
Scenario Outline: Verify that OMS Private Line Domestic Digital direct order can be submitted 
	Given I am logged in as a "Commercial" user in SFA
	When I submit "<order_type>" OMS direct order for lite Private Line Domestic Digital product in "QC" region with "Optical Private Line Non-recurring" and "Default" form 
	Then I should see the order status as "Order Submitted" 
	Examples: 
		| order_type				|
		| New Connect				|
		| Change Existing Service	| 		 
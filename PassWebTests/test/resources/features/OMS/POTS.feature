@Regression @CoreConnect @OMS 
Feature: Verify ordering Core Connect product 

@DirectOrder @Sanity
Scenario Outline: Verify that OMS Core Connect direct order can be submitted 
	Given I am logged in as a "Commercial" user in SFA 
	When I submit "<order_type>" OMS direct order for lite Core Connect Package product in "QC" region 
	Then I should see the order status as "Order Submitted" 
	Examples: 
		| order_type				|
		| New Connect				|
		| Change Existing Service	| 

@OptyOrder @Sanity
Scenario Outline: Verify that OMS Core Connect opty order can be submitted 
	Given I am logged in as a "Commercial" user in SFA 
	When I submit "<order_type>" OMS opty order for lite Core Connect Package product in "QC" region 
	Then I should see the order status as "Order Submitted" 
	Examples: 
		| order_type				|
		| New Connect				|
		| Change Existing Service	|
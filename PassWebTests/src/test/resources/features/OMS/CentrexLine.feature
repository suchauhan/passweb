@Regression @Centrex @OMS 
Feature: Verify ordering Centrex Line product 

@DirectOrder @Sanity 
Scenario Outline: Verify that OMS Centrex Line direct order can be submitted 
	Given I am logged in as a "Commercial" user in SFA 
	When I submit "<order_type>" OMS direct order for lite Centrex Line product in "QC" region 
	Then I should see the order status as "Order Submitted" 
	Examples: 
		| order_type				|
		| New Connect				|
		| Change Existing Service	| 
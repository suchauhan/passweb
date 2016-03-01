@Regression @ComplexVoice @OMS 
Feature: Verify ordering Complex Voice product 

@DirectOrder @Sanity 
Scenario Outline: Verify that OMS Complex Voice direct order can be submitted 
	Given I am logged in as a "Commercial" user in SFA 
	When I submit "<order_type>" OMS direct order for lite Complex Voice product in "QC" region 
	Then I should see the order status as "Order Submitted" 
	Examples: 
		| order_type				|
		| New Connect				|
		| Change Existing Service	|
		
@DirectOrder @Sanity @E9112 
Scenario Outline: Verify that OMS Complex Voice direct order can be submitted 
	Given I am logged in as a "Commercial" user in SFA 
	When I submit "<order_type>" OMS direct order for lite Complex Voice product in "QC" region with "Uniform Access Solution" and "Default" form 
	Then I should see the order status as "Order Submitted" 
	Examples: 
		| order_type				|
		| New Connect				|
		| Change Existing Service	| 			 
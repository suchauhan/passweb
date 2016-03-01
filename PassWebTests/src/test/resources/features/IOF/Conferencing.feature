@Regression @Conferencing @IOF 
Feature: Verify ordering Conferencing product 

@DirectOrder 
Scenario Outline: Verify that IOF Conferencing direct order can be submitted 
	Given I am logged in as a "Commercial" user in SFA 
	When I submit "<Order_Type>" iof direct order for lite Conferencing product in "QCC" region 
	Then I should see the order status as "Order Submitted" 
	Examples: 
		| Order_Type 				|
		| Add New Services 			|
		| Change Existing Services 	|
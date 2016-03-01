@Regression @SavvisOpty
Feature: Savvis Opty Scenarios 

@US14669 
Scenario Outline: Verify that the product type changes based on the sub-type of Savvis opty 
	Given I am logged in as a "Commercial" user in SFA 
	And I create a Savvis opty with sub-type as "<sub_type>" 
	When I add "IQ SIP" product to the opty 
	Then the product type should be "<product_type>" 
	Examples: 
		| sub_type          | product_type        |
		| New Service       | Change              |
		| Retention         | Renewal             |
		| Product Migration | Product Migration   |
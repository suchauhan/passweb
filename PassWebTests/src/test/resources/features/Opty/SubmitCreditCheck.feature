@Regression @US16293 @SubmitCreditCheck 
Feature: Credit Checks automatically approved in test environments 

@US16293_TC10934_TC10937_TC10938_TC10939_TC10940_TC10941 
Scenario: Verify submit credit check in test environment 
	Given I am logged in as a "Admin" user in SFA 
	And I set Credit Check Override as "YES" 
	And I log back as a "Commercial" user in SFA 
	And I have an existing "cpq_commercial_opty" opty data 
	And I have a product added to the CPQ Commercial opty 
	When I submit credit check on the opty 
	Then credit status field is set to "Approved" 
	And credit approval id is set to "999" 
	And credit message is set to "Automatically Approved via SFA Environment Configuration" 
	When I pullback the credit check on the opty 
	Then credit status field is set to "Pullback" 
	
@US16293_TC11139_TC11140 
Scenario: Verify BAU flow for Credit check with Credit Check Override Label as No 
	Given I am logged in as a "Admin" user in SFA 
	And I set Credit Check Override as "NO" 
	And I log back as a "Commercial" user in SFA 
	And I have an existing "cpq_commercial_opty" opty data 
	And I have a product added to the CPQ Commercial opty 
	When I submit credit check on the opty 
	Then credit status field is NOT set to "Approved" 
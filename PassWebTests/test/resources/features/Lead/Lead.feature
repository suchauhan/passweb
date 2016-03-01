@Regression @Lead
Feature: Various operations on leads 

@SomeshCompleted @SalesLeadCreation @SpartansAutomated 
Scenario: Verify commercial user is able to create sales lead 
	Given I am logged in as a "Commercial" user in SFA 
	When I create a sales lead 
	Then sales lead should be created successfully
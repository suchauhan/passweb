Feature: check

@Salesss
Scenario: Check End to End from Sales Draft to Sales Final
    Given I am logged in as a "Commercial" user in SFA 
	And I have an existing commercial opportunity 
	When I create LCTS Services Only NSP 
	Then NSP step should be moved to "POM Analysis" 
	When I log back as a "POM Analyst" user in SFA 
	And I open the NSP 
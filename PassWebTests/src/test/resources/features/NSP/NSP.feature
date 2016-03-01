@Regression @NSP
Feature: Verify the steps on NSP page 

@POMAnalysisSteps 
Scenario: Verify that the NSP step is moved to Closed status on selecting the Big Machine Quote under NSP Status for an Oppty with Solution scope as LCTS Services Only 
	Given I am logged in as a "ssocommercial" in SSO 
	And I open the NSP 
	
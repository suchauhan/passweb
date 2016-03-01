@Regression @Account
Feature: I should be able to create different types of accounts with different types of users 

@CommercialAccount @Sanity @test1
Scenario: Account Creation and Approval, Add Service Location 
	Given I am logged in as a "Commercial" user in SFA 
	When I create a commercial customer account 
	Then account should be created successfully 
	When I validate headquarters and billing address of account 
	Then headquarters and billing address of account should be validated successfully 
	When I add a service location to account 
	Then I should see the service location added to account 
	When I log back as a "ComSalesOp" user in SFA 
	And I open account 
	And I change account status to "Approved" 
	Then account status should be "Approved" 

@AccountHierarchy @TC7353 @TC7354 
Scenario:
Verify that Account Hirearchy Fields are matching for Commercial account are updated for commercial and Partner user. 
	Given I am logged in as a "Commercial" user in SFA 
	And I capture account details of an approved commercial account with mcid 
	When I open account hierarchy page 
	Then I should see the captured account details in account hierarchy page 

@Accounts @CommercialAccount @AccountTransfer @Negative @TC5990 
 Scenario: Verify that when an account is transferred the old sales user cannot edit and the new sales user can edit the account
	Given I am logged in as a "Commercial" user in SFA 
	And I have a commercial account for owner transfer 
	When I transfer the account from current owner to new owner 
	Then I should see account owner as new owner 
	When I try to modify the account as "old_owner" 
	Then I should see insufficient privileges error page 
	When I try to modify the account as "new_owner" 
	Then I should see the account edit page 
	
@CommercialAccount @TC1586 
Scenario: Create Commercial account with Head Quarter address and no Billing Address 
	Given I am logged in as a "Commercial" user in SFA 
	When I create a commercial customer account with no billing address 
	Then account should be created successfully 

@CommercialAccount @TC1583 
Scenario: Create commercial account with Billing Address and no Head Quarter address 
	Given I am logged in as a "Commercial" user in SFA 
	When I create a commercial customer account with no headquarters address 
	Then I should see create account error message as "International and US Headquarters Address information is required (Street, City, Country)" 

@CommercialAccount @TC1606 
Scenario: Verify that Direct Order cannot be initiated for Unapproved Account 
	Given I am logged in as a "Commercial" user in SFA 
	And I have an unapproved commercial account 
	When I initiate direct order 
	Then I should see direct order error as "The Order cannot be created for Unapproved Opportunity Account." 

@CommercialAccount @TC2638 
Scenario: Verify that direct order creation page is redirected to opty record type selection page when BSG Sales user selects yes option for revenue uplift question 
	Given I am logged in as a "Commercial" user in SFA 
	And I have an approved commercial account 
	When I initiate direct order that uplifts revenue 
	Then I should be redirected to opty creation 
	
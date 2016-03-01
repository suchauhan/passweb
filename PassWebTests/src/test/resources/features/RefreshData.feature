Feature: This feature creates all the necessary data after the environment undergoes refresh

  @approved_commercial_account
  Scenario: Create approved_commercial_account data
    Given I am logged in as a "Commercial" user in SFA
    When I create a commercial customer account
    Then commercial customer account should be created successfully
    When I validate headquarters and billing address of account
    Then headquarters and billing address of account should be validated successfully
    When I add a service location to account
    Then I should see the service location added to account
    When I log back as a "ComSalesOp" user in SFA
    And I open and approve account
    Then account should be approved successfully
    And I save "account_name" as "approved_commercial_account" in data xml

  @commercial_opty
  Scenario: Create commercial_opty data
    Given I am logged in as a "Commercial" user in SFA
    When I create a commercial opportunity
    Then commercial opty should be created successfully
    And I save "opty_name" as "commercial_opty" in data xml

  @cpq_commercial_opty
  Scenario: Create cpq commercial opty data
    Given I am logged in as a "Commercial" user in SFA
    When I create a cpq_commercial opportunity
    Then cpq commercial opty should be created successfully
    And I save "opty_name" as "cpq_commercial_opty" in data xml

  @unapproved_commercial_account
  Scenario: Create unapproved_commercial_account data
    Given I am logged in as a "Commercial" user in SFA
    When I create a commercial customer account
    Then commercial customer account should be created successfully
    And I save "account_name" as "unapproved_commercial_account" in data xml

@completeRegression
Feature: Check complete Regression

  Scenario: Check the complete flow of NSP from SFA to PASS as sales user
    Given I am logged in as a "ssocommercial" user in SSO
    When I create a commercial opportunity
    When I create a new NSP
    And I move to PASS through SFA
    Then I should be in PASS and create the NSP in PASS
    And I add the competitor info
    When I select Entity and Product and adding it manually
      | LCTL | Metro Ethernet (LCTL) |
      | LCTL | Metro Ethernet (LCTL) |
      | LCTL | Metro Ethernet (LCTL) |
    And Component Row should get added
    And Component Row should get Deleted
    When I should be able to compare MassUpdate and UpdateKeyfields for the product
    And I am checking the errors and correcting it
    When I submitting the NSP to POM
    Then NSP status should be changed to Sales Final

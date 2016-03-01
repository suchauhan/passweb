@checkDealMetricesValues
Feature: Check Deal Metrics Values

  Scenario: Check Deal Metrics Values
    Given I am logged in as a "POM" user in SSO
    When I search an existing NSP 
    When I get the dealmetrices of NSP in SFA
    And I move to PASS through SFA
    When I open the Deal Summary Page in PASS
    
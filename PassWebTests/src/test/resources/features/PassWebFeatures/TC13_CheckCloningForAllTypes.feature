@cloning
Feature: Cloning of NSP

  Scenario: Check that Cloning of NSP is working for all product types
    Given I am logged in as a "ssocommercial" user in SSO
    When I search an existing NSP
    And I move to PASS through SFA
    When I try to clone a NSP
    Then I should be able to clone successfully
    When I move back to initial version of NSP

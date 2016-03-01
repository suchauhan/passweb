@Mass5
Feature: Add Component Verfication

  Scenario: Check Add Component feature for all the product types
    Given I am logged in as a "ssocommercial" user in SSO
    When I search an existing NSP
    And I move to PASS through SFA
    When I select Entity and Product for adding it
      | LCTL | Metro Ethernet (LCTL)           |
    Then Component Row should get added.
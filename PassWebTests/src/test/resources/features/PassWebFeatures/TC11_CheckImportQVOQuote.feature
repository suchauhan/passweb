@importQVO
Feature: Import QVO Quote in Passweb

  Scenario: Check that import PP quote is working for all product types
    Given I am logged in as a "ssocommercial" user in SSO
    When I search an existing NSP
    And I move to PASS through SFA
    When I import the QVO Quote in Passweb
    Then I should be able import QVO Quote successfully
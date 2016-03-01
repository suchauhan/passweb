@addProduct2
Feature: Add Product in Passweb

  Scenario: Check that add product feature is working for all product types
    Given I am logged in as a "ssocommercial" user in SSO
    When I search an existing NSP
    And I move to PASS through SFA
    And I should be in PASS and load the new NSP
    When I select Entity and Product and adding it manually
      | LEQ | Dedicated IP Bundle (LEQ) |
    And I am checking the errors and correcting it

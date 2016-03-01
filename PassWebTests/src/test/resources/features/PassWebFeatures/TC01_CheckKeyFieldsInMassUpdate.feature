@Mass1
Feature: KeyFields and MassUpdateFields comparison

  Scenario: Check Key fields arent in the mass update in all types of product
    Given I am logged in as a "ssocommercial" user in SSO
    When I search an existing NSP
    And I move to PASS through SFA
    When I select Entity and Product for adding it
      | LCTL | Metro Ethernet (LCTL) |
    Then I should be able to compare MassUpdate and UpdateKeyfields for the product.

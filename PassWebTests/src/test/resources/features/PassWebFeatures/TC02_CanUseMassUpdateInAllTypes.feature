@Mass2
Feature: Mass Update Field Usage check

  Scenario: Check Mass Update field usage in all product types
    Given I am logged in as a "ssocommercial" user in SSO
    When I search an existing NSP
    And I move to PASS through SFA
    When I select Entity and Product for adding it
      | LCTL | Metro Ethernet (LCTL)           |
      | QC   | Optical Wavelength Service (QC) |
    Then I should be able to use mass update and populate values in fields for the product

@TestinPASS
Feature: NSP Sales Draft to Sales Final

  Scenario: Check End to End from Sales Draft to Sales Final
    Given I am logged in as "Admin" user in Passweb
    Then I should be in PASS and load the NSP
    When I select Entity and Product and adding it manually
      | QCC | LD Voice - International (QCC) |
    Then Product should get added
    And I am checking the errors and correcting it
    When I submitting the NSP to POM
    Then NSP status should be changed to Sales Final
    And I logout from the PASS and close the browser
    And I move back to SFA and get the NSP number

  Scenario: Check End to End from POM Draft to Sales Final
    Given I am logged in as a "ssocommercial" user in SSO
    When I search an existing NSP
    And I move to PASS through SFA
    Then I should be in PASS and load the NSP

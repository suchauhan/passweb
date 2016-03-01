@TestinPASS
Feature: NSP Sales Draft to Sales Final

  Scenario: Check End to End from Sales Draft to Sales Final
    Given I am logged in as "Admin" user in Passweb
    Then I should be in PASS and load the new NSP
    When I select Entity and Product and adding it manually
      | QCC | iQ Standard (QCC) |
    Then Product should get added
    And I am checking the errors and correcting it
    When I submitting the NSP to POM
    Then NSP status should be changed to Sales Final

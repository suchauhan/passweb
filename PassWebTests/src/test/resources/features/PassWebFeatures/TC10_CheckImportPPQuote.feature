@importPP
Feature: Import PP Quote in Passweb

  Scenario: Check that import PP quote is working for all product types
    Given I am logged in as a "ssocommercial" user in SSO
    When I create a commercial opportunity
    When I create a new NSP
    And I move to PASS through SFA
    Then I should be in PASS and load the new NSP
    When I import the PP Quote of "iQ Bundle (QCC)" in PASS
    Then I should be able import PP Quote successfully
    And I am checking the errors and correcting it
    When I submitting the NSP to POM
    Then NSP status should be changed to Sales Final
    
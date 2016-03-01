Feature: I should be able to login as different users to the salesforce application

  @Login
  Scenario: Login Scenario
    Given I am logged in as a "ssocommercial" user in SSO
    Then I should be on home page
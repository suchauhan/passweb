@SSO3
Feature: SSO Login

  Scenario: SSO1 Login
    Given I am logged in as "ssocommercial" user in SSO 
    Then I should be at the home page
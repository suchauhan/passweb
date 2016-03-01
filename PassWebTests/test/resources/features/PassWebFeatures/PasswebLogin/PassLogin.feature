@PassWeb
Feature: Passweb Login Feature

  Scenario: Passweb Login
    Given I am logged in as "ssocommercial" user in SSO
    Then I should be at the home page

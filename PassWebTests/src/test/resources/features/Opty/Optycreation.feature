Feature: I should be able to create a Opportunity

  @Optycreation1
  Scenario: Optycreation Scenario
    Given I am logged in as a "POM User" user in SSO
    When I create a commercial opportunity
    And I add an "OMS" product to opty
    Then I should be on home page

@BigMac
Feature: I should be able to make modifications in BigMac quotes

  Scenario: Login Scenario
    
    Given I am logged in as "Admin" to BigMac environment
    And I have an existing CPQ opportunity 
    When I edit the opportunity
    Then It should be able to edit it and save it


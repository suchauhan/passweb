@Regression @SDP
Feature: SDP Scenarios

  @Sanity @DirectOrder
  Scenario: Verify that SDP order can be submitted to back office as a Commercial user(Complete CCID creation task, Submit SDP order to back office)
    Given I am logged in as a "ssocommercial" user in SSO
    When I submit "Install" SDP direct order for "IQ Internet" product in "QCC" region
    Then I should see the SDP order status as "Submitted to OEC"

  @Sanity @OptyOrder
  Scenario: Verify that SDP opty order can be submitted to back office as a Commercial user
    Given I am logged in as a "ssocommercial" user in SSO
    When I submit "Install" SDP opty order for "IQ Internet" product in "QCC" region
    Then I should see the SDP order status as "Submitted to OEC"
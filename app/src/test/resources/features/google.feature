Feature: Testing the search in Google

@Test
Scenario: I search something in Google
    Given I navigate to Google
    When I enter a search criteria
    And I click on the search button
    Then I get the results
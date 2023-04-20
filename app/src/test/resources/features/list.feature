Feature: Testing with lists

Scenario Outline: As a Test Engineer, I want to validate that a text is present inside the list
    Given I navigate to the list page
    When I search <text> in the list
    Then I can find <searchedText> in the list

    Examples:
    |text   |searchedText|
    |Arizona|Arizona     |
    |A      |California  |
    |Se     |New Jersey  |
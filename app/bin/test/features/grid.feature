Feature: Testing the grids

Rule: The user can return values from the table and validate them

Background: Navigate to Table web app (no mas de 2 pasos en el background)
    Given: I navigate to the Grid page

Scenario: I get a value of a specific cell in a grid
    Then I get the text of the cell that I need
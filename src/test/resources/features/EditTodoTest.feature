Feature: As an users, I want to edit todo

  @test
  Scenario Outline: Edit to do
    Given I place in the homepage
    When I click on the add button
    When I add a new todo "<title>"
    When I click on item "<title>" in list
    When I input todo with title "<title_update>"
    When I switch on reminder
    When I submit add the todo
    Then I should see the todo "<title_update>" displayed in the list
    Examples:
      | title   | title_update   |
      | To do 1 | To to 1 Update |



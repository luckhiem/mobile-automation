Feature: As an users, I want to add todo

  @test
  Scenario Outline: Add todo without reminder
    Given I place in the homepage
    When I click on the add button
    When I input todo with title "<title>"
    When I submit add the todo
    Then I should see the todo "<title>" displayed in the list
    Examples:
      | title  |
      | todo_1 |
      | todo_2 |

  @test
  Scenario Outline: Add todo with reminder
    Given I place in the homepage
    When I click on the add button
    When I input todo with title "<title>"
    When I switch on reminder
    When I input datetime with "<date>" and "<time>" in reminder
    When I submit add the todo
    Then I should see the todo "<title>" displayed in the list
    Examples:
      | title  | date          | time     |
      | todo_1 | 30 April 2022 | 10:00 PM |
      | todo_2 | today         | 10:00 PM |


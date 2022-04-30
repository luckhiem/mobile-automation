Feature: As an users, I want to checking about page

  @night_mode
  Scenario Outline: Check about page
    Given I place in the homepage
    When I click on setting app
    And I click on setting button
    When I check "<mode>" night mode setting
    Then I should see night mode "<mode>"
    Examples:
      | mode |
      | on   |
      | off  |



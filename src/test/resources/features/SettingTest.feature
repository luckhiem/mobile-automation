Feature: As an users, I want to checking about page

  @test
  Scenario Outline: Check setting page
    Given I place in the homepage
    When I click on setting app
    And I click on setting button
    When I check "<mode>" night mode setting
    Then I should see night mode "<mode>"
    Examples:
      | mode |
      | on   |
      | off  |

  @test
  Scenario: Check setting page
    Given I place in the homepage
    When I click on setting app
    And I click on about button
    Then I should see about page is displayed



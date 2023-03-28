Feature: Google search

  Scenario: Verifying the result for google search
    Given I am on the google page
    When I search for "cucumber"
    Then I should see only "cucumber" related results
    
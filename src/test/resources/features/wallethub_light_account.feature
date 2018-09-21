@wallethub @assignment2
Feature: WalletHub Light User Account

  @removeReview
  Scenario: As a User I should be able to write review
    Given user opens wallethub company page
    And user logs in with VALID credentials
    Then user should be logged in
    When user hovers over 5 star raiting
    Then 5 stars should be filled
    When user clicks on the 5 star
    Then user should be on write review page
    When user selects policy type to be "Health"
    And user enters generated review
    And user sets rating to be 5 stars
    And user presses submit button
    Then review confirmation page should be visible
    When user navigates to user profile reviews section
    Then added review should be visible



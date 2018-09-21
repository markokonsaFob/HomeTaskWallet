@facebook @assignment1
Feature: Facebook Login

  ## Please code a Java Selenium 2 code, which we can run on our end, that does this:
  # 1. Login to Facebook. Username and Password should be a variable we can change
  # 2. Post a status message "Hello World"

  Scenario: As a User I should be able to login to Facebook and post
    Given user opens Facebook home page
    Then Facebook home page should be visible
    When user enters VALID credentials into the login field
    And user clicks submit button on Facebook login
    Then user should be logged in to Facebook
    When user navigates to profile view on Facebook
    And user posts a status update with message "Hello World" on Facebook
    Then status update posted "Just now" with message "Hello World" should be visible
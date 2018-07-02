@test
Feature: Search in Google

  Background:
    Given user lands on "amazon" home page

  Scenario Outline: Sign up a new account
    When user click "Sign in" button
    Then user should land on "Sign in" page
    And user click "Create your Amazon account" button
    Then user should land on "Create account" page
    Then user inputs "<name>" in the field "Your name"
    And user inputs "<email>" in the field "Email"
    And user inputs "<password>" in the field "Password"
    And user inputs "<re-password>" in the field "Re-enter password"
    Then user click "Create your Amazon account" button
#    Then user should see "Email address already in use" on the page

    Examples:
      | name      | email             | password  | re-password
      | peng chen1 | chenpeng1@test.com | password1 | password1
      | peng chen2 | chenpeng2@test.com | password1 | password1
      | peng chen3 | chenpeng3@test.com | password1 | password1
      | peng chen4 | chenpeng4@test.com | password1 | password1
      | peng chen5 | chenpeng5@test.com | password1 | password1
      | peng chen6 | chenpeng6@test.com | password1 | password1
      | peng chen7 | chenpeng7@test.com | password1 | password1
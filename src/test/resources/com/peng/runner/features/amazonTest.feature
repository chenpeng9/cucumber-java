@test
Feature: Sign up an Amazon account

  Background:
    Given user lands on "amazon" home page

  @test1
  Scenario Outline: Sign up a new account - Pass
    Then user take a screenshot
    When user click "Sign in" button
    Then user should land on "Sign in" page
    And user click "Create your Amazon account" button
    Then user should land on "Create account" page
    Then user capture this page as "createAccount" and save to "screenshots/"
    Then user inputs "<name>" in the field "Your name"
    And user inputs "<email>" in the field "Email"
    And user inputs "<password>" in the field "Password"
    And user inputs "<re-password>" in the field "Re-enter password"
    Then user click "Create your Amazon account" button

    Examples:
      | name      | email             | password  | re-password |
      | peng chen1 | chenpeng1@test.com | password1 | password1 |

  Scenario: Sign up a new account - Failed
    When user click "Sign in" button
    Then user should land on "Sign in" page
    And user click "Create your Amazon account" button
    Then user should land on "Create account" page
    Then user inputs "peng" in the field "Your name"
    And user inputs "test@test.com" in the field "Email"
    And user inputs "Password1" in the field "Password"
    And user inputs "Password1" in the field "Re-enter password"
    Then user click "Create your Amazon account" button
    Then user should see "rerun" on the page
@smoke
Feature: Test Login Functionality

  Background:user navigate to page and close it after finish
    Given user navigate to login page

  Scenario: user could login with valid email and password
    When enter email "attyamebed@gmail.com" and password "Attya@mebed"
    And user press login
    Then user go to home page

  Scenario: user could login with invalid email and password
    When enter email "attya@gmail.com" and password "attya123"
    And user press login
    Then check on error message

  Scenario: Enter invalid email form
    When enter email "Att" and password "Meb"
    Then check on email error message

  Scenario: user forget Password
    When user press forget password
    And user enter email "attyamebed@gmail.com"
    And user press recover button
    Then user gets instructions message has been sent
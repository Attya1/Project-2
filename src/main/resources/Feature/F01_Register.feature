@smoke
Feature: test register
  Background:user navigate to page and close it after finish
    Given initialize register feature

  Scenario: Register with valid data

    When user press register icon
    And user selects "male" and enters "attya" as first name, "mebed" as last name, "attyamebed@gmail.com" as email, "AttyaCO" as company, "Attya@mebed" as password and "Attya@mebed" as confirm password
    And user set his birthday as follow "29" Day "7" Month "1994" Year
    And user clicks on register button
    Then successful registration message appears

  Scenario: user didn't enter any data

    When user press register icon
    And user clicks on register button
    Then error messages appear

  Scenario: user didn't enter the same password

    When user press register icon
    And user selects "male" and enters "attya" as first name, "mebed" as last name, "attyamebed@gmail.com" as email, "AttyaCO" as company, "Attya@mebed" as password and "Atty@mebed" as confirm password
    And user set his birthday as follow "29" Day "7" Month "1994" Year
    And user clicks on register button
    Then user get non identical passwords

  Scenario: email already exist

    When user press register icon
    And user selects "male" and enters "attya" as first name, "mebed" as last name, "attyamebed@gmail.com" as email, "AttyaCO" as company, "Attya@mebed" as password and "Attya@mebed" as confirm password
    And user set his birthday as follow "29" Day "7" Month "1994" Year
    And user clicks on register button
    Then email exist message appears

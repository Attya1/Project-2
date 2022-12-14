@smoke
Feature: test follow us
  Background:user navigate to page and close it after finish
    Given initialize follow us feature
  Scenario Outline: user clicks follow us icons
    When user clicks "<Icons>"
    Then user should go to selected "<page>"
    Examples:
      |Icons|      |page|
      |facebook|   |https://www.facebook.com/nopCommerce|
      |twitter|    |https://twitter.com/nopCommerce|
      |rss|        |https://demo.nopcommerce.com/new-online-store-is-open|
      |youtube|    |https://www.youtube.com/user/nopCommerce|

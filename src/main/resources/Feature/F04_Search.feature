@smoke
Feature: test search
  Background:user navigate to page and close it after finish
    Given initialize Search feature
  Scenario Outline: : search products with name
    When user types "<productName>"
    And clicks on search
    Then user should find the "<productName>"
    Examples:
      |productName|
      |camera|
      |laptop|
      |t-shirt|

  Scenario Outline: : search products with sku
    When user types "<productSku>" as product sku
    And clicks on search
    Then user should find the "<productSku>" as product sku
    Examples:
      |productSku|
      |LT_MIR_DC|
      |LE_TX1_CL|
      |CS_TSHIRT|
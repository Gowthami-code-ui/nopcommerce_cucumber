Feature: Login

  Scenario Outline:Login with Data Driven
    Given user Lanuch Chrome browser
    When User opens URL "https://admin-demo.nopcommerce.com/login"
    And USer enters Email as "<email>" and Password as "<password>"
    And Click Login
    Then Page Title should be "Dashboard / nopcommerce administration"
    When User click on Log out link
    Then Page Title should be "Your store. Login"
    And close browser
    
    Examples:
      |email               |password|
      |admin@yourstore.com  |admin|
      |admin12@yourstore.com|admin12|

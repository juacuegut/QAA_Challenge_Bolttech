Feature: Cart functionality scenarios

  Background:
    Given I am in the Bolttech webpage
    And I accept cookies
    And I click in a value of the device price dropdown list
    And I can see dynamic prices updated properly

  Scenario: Checking Product Summary page
    When I click in Select card
    Then I am redirected to the product summary
    And I can see original price strike through
    And Current price at zero
    And Expected product name
    And Bolttech as provider
    And Contract start date in Thailand Timezone
    And Contract renewal as Monthly
    And Billing start date
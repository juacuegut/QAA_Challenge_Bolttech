Feature: Price dropdown functionality scenarios

    Background:
      Given I am in the Bolttech webpage
      And I accept cookies

    Scenario: Selecting specific value of the price dropdown list
      When I click "THB 10,001 - 15,000" in the device price dropdown list
      Then I can see dynamic prices updated properly

    Scenario: Selecting random value of the price dropdown list
      When I click in a value of the device price dropdown list
      Then I can see dynamic prices updated properly
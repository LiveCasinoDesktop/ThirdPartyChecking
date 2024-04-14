@Priority @Priority1 @Evolution
Feature: Checking Table List in Evolution Casino

  Background: Logging In
    And Login Account
    When I Join "Evolution" Casino

  Scenario: Checking Evolution All Games
    And Get All "Baccarat & Sic Bo" Tables of Evolution
    And Verify "Baccarat & Sic Bo" of Evolution

    And Get All "Roulette" Tables of Evolution
    And Verify "Roulette" of Evolution

    And Get All "Poker" Tables of Evolution
    And Verify "Poker" of Evolution

    And Get All "Game Shows" Tables of Evolution
    And Verify "Game Shows" of Evolution

    And Display JSON "Evolution"
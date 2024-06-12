#@Priority @Priority1 @AllBet
Feature: Checking Table List in Evolution Casino

  Background: Logging In
    And Login Account
    When I Join "All Bet" Casino

  @trials
  Scenario: Checking all games of Evolution

    When Try to get All "Baccarat & Sic Bo" Tables of Evolution
    Then Verify "Baccarat & Sic Bo" of Provider Evolution

    When Try to get All "Roulette" Tables of Evolution
    Then Verify "Roulette" of Provider Evolution

    When Try to get All "Poker" Tables of Evolution
    Then Verify "Poker" of Provider Evolution

    When Try to get All "Game Shows" Tables of Evolution
    Then Verify "Game Shows" of Provider Evolution


@Priority @Priority1 @AllBet
Feature: Checking Table List in Evolution Casino

  Background: Logging In
    And Login Account
    When I Join "All Bet" Casino

  @trials
  Scenario: Checking all games of Evolution

    When Try to get All "Baccarat" Tables of AllBet
    Then Verify "Baccarat" of Provider AllBet

    When Try to get All "Dragon Tiger" Tables of AllBet
    Then Verify "Dragon Tiger" of Provider AllBet

    When Try to get All "SicBo" Tables of AllBet
    Then Verify "SicBo" of Provider AllBet

    When Try to get All "Roulette" Tables of AllBet
    Then Verify "Roulette" of Provider AllBet

    When Try to get All "Bull Bull" Tables of AllBet
    Then Verify "Bull Bull" of Provider AllBet

    When Try to get All "HiLo" Tables of AllBet
    Then Verify "HiLo" of Provider AllBet

    When Try to get All "Classic PokDeng" Tables of AllBet
    Then Verify "Classic PokDeng" of Provider AllBet

    When Try to get All "Casino War" Tables of AllBet
    Then Verify "Casino War" of Provider AllBet

    When Try to get All "Two Sides PokDeng" Tables of AllBet
    Then Verify "Two Sides PokDeng" of Provider AllBet

    When Try to get All "Fish Prawn Crab" Tables of AllBet
    Then Verify "Fish Prawn Crab" of Provider AllBet

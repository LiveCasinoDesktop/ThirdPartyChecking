Feature: Checking Table List in Evolution Casino

  Background: Logging In
    When I Go To SBOTOP
    And Login Account
    When I Join "Evolution" Casino

  Scenario: Checking EVO Game Baccarat & Sic Bo
    And Get All Table Names of "Baccarat & Sic Bo" of "Evolution"
    Then Verify "Baccarat & Sic Bo" of "Evolution"
    And Print Text File "Evolution"

  Scenario: Checking EVO Game Roulette
    And Get All Table Names of "Roulette" of "Evolution"
    Then Verify "Roulette" of "Evolution"
    And Print Text File "Evolution"

  Scenario: Checking EVO Game Poker
    And Get All Table Names of "Poker" of "Evolution"
    Then Verify "Poker" of "Evolution"
    And Print Text File "Evolution"

  Scenario: Checking EVO Game Game Shows
    And Get All Table Names of "Game Shows" of "Evolution"
    Then Verify "Game Shows" of "Evolution"
    And Print Text File "Evolution"
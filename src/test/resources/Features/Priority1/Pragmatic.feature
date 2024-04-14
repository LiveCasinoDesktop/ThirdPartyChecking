@Priority @Priority1 @Pragmatic
Feature: Checking Table List in Pragmatic Casino

  Background: Logging In
    And Login Account
    When I Join "Pragmatic" Casino


  Scenario: Checking Pragmatic All Games
    And Get All "Baccarat" Tables of Pragmatic
    And Verify "Baccarat" of Pragmatic

    And Get All "Roulette" Tables of Pragmatic
    And Verify "Roulette" of Pragmatic

    And Get All "Game Shows" Tables of Pragmatic
    And Verify "Game Shows" of Pragmatic

    And Get All "Sic Bo" Tables of Pragmatic
    And Verify "Sic Bo" of Pragmatic

    And Get All "Dragon Tiger" Tables of Pragmatic
    And Verify "Dragon Tiger" of Pragmatic

    And Get All "Andar Bahar" Tables of Pragmatic
    And Verify "Andar Bahar" of Pragmatic

    And Display JSON Pragmatic

  Scenario: Checking Baccarat Pragmatic Game
    And Get All Table Names of "Baccarat" of "Pragmatic"
    Then Verify "Baccarat" of "Pragmatic"
    And Print Text File "Pragmatic"

  Scenario: Checking Roulette Pragmatic Game
    And Get All Table Names of "Roulette" of "Pragmatic"
    Then Verify "Roulette" of "Pragmatic"
    And Print Text File "Pragmatic"

  Scenario: Checking Game Shows Pragmatic Game
    And Get All Table Names of "Game Shows" of "Pragmatic"
    Then Verify "Game Shows" of "Pragmatic"
    And Print Text File "Pragmatic"

  Scenario: Checking Sic Bo Pragmatic Game
    And Get All Table Names of "Sic Bo" of "Pragmatic"
    Then Verify "Sic Bo" of "Pragmatic"
    And Print Text File "Pragmatic"

  Scenario: Checking Dragon Tiger Pragmatic Game
    And Get All Table Names of "Dragon Tiger" of "Pragmatic"
    Then Verify "Dragon Tiger" of "Pragmatic"
    And Print Text File "Pragmatic"

  Scenario: Checking Andar Bahar Pragmatic Game
    And Get All Table Names of "Andar Bahar" of "Pragmatic"
    Then Verify "Andar Bahar" of "Pragmatic"
    And Print Text File "Pragmatic"
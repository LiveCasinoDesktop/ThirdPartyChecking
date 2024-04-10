Feature: Checking Table List in Pragmatic Casino

  Background: Logging In
    When I Go To SBOTOP
    And Login Account
    When I Join "Pragmatic" Casino

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
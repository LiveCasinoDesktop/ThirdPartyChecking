@Priority @Priority1 @SexyGaming
Feature: Checking Table List in Sexy Gaming Casino

  Scenario: Checking Sexy Gaming All Games

    And Login Account
    When I Join "Sexy" Casino

    And Get All "Baccarat" Tables of Sexy Gaming
    And Verify "Baccarat" of Sexy Gaming

    And Get All "Dragon Tiger" Tables of Sexy Gaming
    And Verify "Dragon Tiger" of Sexy Gaming

    And Get All "Dice" Tables of Sexy Gaming
    And Verify "Dice" of Sexy Gaming

    And Get All "Roulette" Tables of Sexy Gaming
    And Verify "Roulette" of Sexy Gaming

    And Display JSON Sexy Gaming

  @SexyBaccarat
  Scenario: Checking Baccarat Sexy Gaming Game
    And Login Account
    When I Join "Sexy" Casino
    And Get All Table Names of "Baccarat" of "Sexy"
    Then Verify "Baccarat" of "Sexy"
    And Print Text File "Sexy"

  @SexyDragonTiger
  Scenario: Checking Dragon Tiger Sexy Gaming Game
    And Login Account
    When I Join "Sexy" Casino
    And Get All Table Names of "Dragon Tiger" of "Sexy"
    Then Verify "Dragon Tiger" of "Sexy"
    And Print Text File "Sexy"

  @SexyDice
  Scenario: Checking Dice Sexy Gaming Game
    And Login Account
    When I Join "Sexy" Casino
    And Get All Table Names of "Dice" of "Sexy"
    Then Verify "Dice" of "Sexy"
    And Print Text File "Sexy"

  @SexyRoulette
  Scenario: Checking Roulette Sexy Gaming Game
    And Login Account
    When I Join "Sexy" Casino
    And Get All Table Names of "Roulette" of "Sexy"
    Then Verify "Roulette" of "Sexy"
    And Print Text File "Sexy"
@SexyGaming
Feature: Checking Table List in Sexy Gaming Casino

  Background: Logging In
    When I Go To SBOTOP
    And Login Account
    When I Join "Sexy" Casino

  @SexyBaccarat
  Scenario: Checking Baccarat Sexy Gaming Game
    And Get All Table Names of "Baccarat" of "Sexy"
    Then Verify "Baccarat" of "Sexy"
    And Print Text File "Sexy"

  @SexyDragonTiger
  Scenario: Checking Dragon Tiger Sexy Gaming Game
    And Get All Table Names of "Dragon Tiger" of "Sexy"
    Then Verify "Dragon Tiger" of "Sexy"
    And Print Text File "Sexy"

  @SexyDice
  Scenario: Checking Dice Sexy Gaming Game
    And Get All Table Names of "Dice" of "Sexy"
    Then Verify "Dice" of "Sexy"
    And Print Text File "Sexy"

  @SexyRoulette
  Scenario: Checking Roulette Sexy Gaming Game
    And Get All Table Names of "Roulette" of "Sexy"
    Then Verify "Roulette" of "Sexy"
    And Print Text File "Sexy"
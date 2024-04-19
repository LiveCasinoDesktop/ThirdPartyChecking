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

  @trials
  Scenario: Checking all games of Sexy Gaming
    And Login Account
    When I Join "Sexy" Casino

    When Try to get All "Baccarat" Tables of Sexy Gaming
    Then Verify "Baccarat" of Provider Sexy Gaming

    When Try to get All "Dragon Tiger" Tables of Sexy Gaming
    Then Verify "Dragon Tiger" of Provider Sexy Gaming

    When Try to get All "Dice" Tables of Sexy Gaming
    Then Verify "Dice" of Provider Sexy Gaming

    When Try to get All "Roulette" Tables of Sexy Gaming
    Then Verify "Roulette" of Provider Sexy Gaming
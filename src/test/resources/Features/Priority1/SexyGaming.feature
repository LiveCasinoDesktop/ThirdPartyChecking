@Priority @Priority1 @SexyGaming
Feature: Checking Table List in Sexy Gaming Casino

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
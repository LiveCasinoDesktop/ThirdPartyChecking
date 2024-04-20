@Priority @Priority1 @Pragmatic
Feature: Checking Table List in Pragmatic Casino


  @trials
  Scenario: Checking all games of Pragmatic

    And Login Account
    When I Join "Pragmatic" Casino

    When Try to get All "Baccarat" Tables of Pragmatic
    Then Verify "Baccarat" of Provider Pragmatic

    When Try to get All "Roulette" Tables of Pragmatic
    Then Verify "Roulette" of Provider Pragmatic

    When Try to get All "Game Shows" Tables of Pragmatic
    Then Verify "Game Shows" of Provider Pragmatic

    When Try to get All "Sic Bo" Tables of Pragmatic
    Then Verify "Sic Bo" of Provider Pragmatic

    When Try to get All "Dragon Tiger" Tables of Pragmatic
    Then Verify "Dragon Tiger" of Provider Pragmatic

    When Try to get All "Andar Bahar" Tables of Pragmatic
    Then Verify "Andar Bahar" of Provider Pragmatic

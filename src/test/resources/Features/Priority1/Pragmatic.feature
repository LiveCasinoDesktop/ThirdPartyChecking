@Priority @Priority1 @Pragmatic
Feature: Checking Table List in Pragmatic Casino


  Scenario: Checking Pragmatic All Games

    And Login Account
    When I Join "Pragmatic" Casino

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
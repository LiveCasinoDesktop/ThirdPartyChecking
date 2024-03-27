Feature: Checking Table List in Sexy Gaming Casino

  Background: Logging In
    When I Go To SBOTOP
    And Login Account
    When I Join "Sexy" Casino

  Scenario: Checking Baccarat Sexy Gaming Game
    And Get All Table Names of "Baccarat" of "Sexy"
    Then Verify "Baccarat" of "Sexy"
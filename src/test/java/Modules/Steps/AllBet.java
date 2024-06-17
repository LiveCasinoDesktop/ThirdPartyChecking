package Modules.Steps;

import Modules.Steps.featureSteps.AllBetMethods;
import Utilities.Helper.Waiting;
import Utilities.Listeners.Events;
import Utilities.Objects.Component;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;

public class AllBet {
    @When("Try to get All {string} Tables of AllBet")
    public void tryToGetAllTablesOfAllBet(String category) {

        Waiting.element(Modules.Pages.AllBet. NAVIGATION.liveCasino, 60);
        Events.click(Modules.Pages.AllBet.NAVIGATION.liveCasino);

        Component component = switch (category){

            case "Baccarat" -> Modules.Pages.AllBet.NAVIGATION.NAVIGATIONBUTTONS.baccarat;
            case "Dragon Tiger" -> Modules.Pages.AllBet.NAVIGATION.NAVIGATIONBUTTONS.dragonTiger;
            case "SicBo" -> Modules.Pages.AllBet.NAVIGATION.NAVIGATIONBUTTONS.sicBo;
            case "Roulette" -> Modules.Pages.AllBet.NAVIGATION.NAVIGATIONBUTTONS.roulette;
            case "Win Three Cards" -> Modules.Pages.AllBet.NAVIGATION.NAVIGATIONBUTTONS.winThreeCards;
            case "Bull Bull" -> Modules.Pages.AllBet.NAVIGATION.NAVIGATIONBUTTONS.bullBull;
            case "Three Pictures" -> Modules.Pages.AllBet.NAVIGATION.NAVIGATIONBUTTONS.threePictures;
            case "HiLo" -> Modules.Pages.AllBet.NAVIGATION.NAVIGATIONBUTTONS.hiLo;

            case "Classic PokDeng" -> Modules.Pages.AllBet.NAVIGATION.NAVIGATIONBUTTONS.classicPokDeng;
            case "Teen Patti" -> Modules.Pages.AllBet.NAVIGATION.NAVIGATIONBUTTONS.teenPatti;
            case "Andar Bahar" -> Modules.Pages.AllBet.NAVIGATION.NAVIGATIONBUTTONS.andarBahar;
            case "Ultimate Texas Holdem" -> Modules.Pages.AllBet.NAVIGATION.NAVIGATIONBUTTONS.ultimateTexas;
            case "Two Sides PokDeng" -> Modules.Pages.AllBet.NAVIGATION.NAVIGATIONBUTTONS.twoSidesPokDeng;
            case "Casino War" -> Modules.Pages.AllBet.NAVIGATION.NAVIGATIONBUTTONS.casinoWar;
            case "Infinite Blackjack" -> Modules.Pages.AllBet.NAVIGATION.NAVIGATIONBUTTONS.infiniteBlackjack;
            case "Fish Prawn Crab" -> Modules.Pages.AllBet.NAVIGATION.NAVIGATIONBUTTONS.fishPrawnCrab;

            default -> throw new IllegalStateException("Unexpected value: " + category);
        };

        Events.click(component);

        Waiting.fewSeconds(5);

    }

    @Then("Verify {string} of Provider AllBet")
    public void verifyOfProviderAllBet(String category) throws IOException {

        AllBetMethods.printAllTables();

        AllBetMethods.verifyTables(category);
    }
}

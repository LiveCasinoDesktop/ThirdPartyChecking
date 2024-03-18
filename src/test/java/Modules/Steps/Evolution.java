package Modules.Steps;

import Modules.Pages.EvolutionComponents;
import Modules.Pages.SBOTOP;
import Utilities.Helper.Drivers;
import Utilities.Helper.JavaScript;
import Utilities.Helper.Waiting;
import Utilities.Listeners.Events;
import Utilities.Listeners.File;
import Utilities.Objects.Component;
import Utilities.Settings.Constants;
import engine.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;

public class Evolution extends Driver {
    @When("I Go To SBOTOP")
    public void iGoToSBOTOP() {

        driver.get(Constants.URL);
    }

    @And("Login Account")
    public void loginAccount() {

        Waiting.element(SBOTOP.Landing.user, 10);
        Events.sendKeys(SBOTOP.Landing.user, Constants.Accounts.IDR.username);

        Waiting.element(SBOTOP.Landing.pass, 10);
        Events.sendKeys(SBOTOP.Landing.pass, Constants.Accounts.IDR.password);

        Waiting.element(SBOTOP.Landing.login, 10);
        Events.click(SBOTOP.Landing.login);

        Waiting.element(SBOTOP.Landing.accountName, 10);

    }

    @And("Go to Evolution Casino")
    public void goToEvolutionCasino() {

        Waiting.element(SBOTOP.Landing.liveCasino, 10);
        Events.click(SBOTOP.Landing.liveCasino);

        Waiting.element(SBOTOP.Casino.thirdParty, 20);

        Waiting.element(SBOTOP.Casino.evolution, 10);
        Events.click(SBOTOP.Casino.evolution);


        try{

            Waiting.element(SBOTOP.Casino.redirection, 10);
            Events.click(SBOTOP.Casino.redirection);

        }catch (Exception ignore){}


        Drivers.changeWindow();

        Waiting.fewSeconds(5);
        System.out.println(driver.getTitle());

        System.out.println("Changing iFrame...");
        Drivers.changeIFrame(EvolutionComponents.iframe);
    }

    @Then("Verify {string} Tables")
    public void verifyTables(String thirdParty) throws Exception {

        Waiting.element(EvolutionComponents.activeNav, 30);
        Thread.sleep(5000);
        String activeNav = Events.getText(EvolutionComponents.activeNav);
        System.out.println(activeNav);

        Component tablesComponent;
        switch (activeNav){

            case "Roulette" -> tablesComponent = EvolutionComponents.Roulette.rouletteTables;
            case "Poker" -> tablesComponent = EvolutionComponents.Poker.pokerTables;
            case "Game Shows" -> tablesComponent = EvolutionComponents.GameShows.gameShows;
            default -> tablesComponent = EvolutionComponents.Baccarat_SicBo.baccaratTables;

        }

        File.readExcelFile(activeNav, thirdParty);

        Waiting.fewSeconds(5);

        // * GETTING SIZE OF TABLES

        int size = Events.getSize(tablesComponent);
        JavaScript.scrollTo(tablesComponent, size);

        Waiting.fewSeconds(3);

        List<String> tableList = Events.getListText(tablesComponent);
        List<String> excelList = File.gameList;

        for(String table : tableList){

            if(!excelList.contains(table)){

                System.out.println("Table not FOUND: " + table);
            }
            else{

                excelList.remove(table);
            }

        }

        System.out.println("==============================");

        if(excelList != null){

            System.out.println("NOT FOUND TABLE");
            for(String table : excelList){

                System.out.println(table);
            }
        }

    }

    @When("Click {string} Category")
    public void clickCategory(String category) {

        Component component = switch (category) {
            case "Baccarat & Sic Bo" -> SBOTOP.Navigation.baccarat_SicBo;
            case "Poker" -> SBOTOP.Navigation.poker;
            case "Game Shows" -> SBOTOP.Navigation.gameShows;
            default -> SBOTOP.Navigation.roulette;
        };

        Waiting.element(component, 30);
        Events.click(component);
    }
}

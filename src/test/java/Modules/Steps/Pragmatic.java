package Modules.Steps;

import Modules.Pages.EvolutionComponents;
import Modules.Pages.SBOTOP;
import Utilities.Helper.Drivers;
import Utilities.Helper.JavaScript;
import Utilities.Helper.Waiting;
import Utilities.Listeners.Events;
import Utilities.Listeners.File;
import Utilities.Objects.Component;
import engine.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Pragmatic extends Driver {
    @And("Go to Pragmatic Casino")
    public void goToPragmaticCasino() {


        Waiting.element(SBOTOP.Casino.pragmatic, 10);
        //JavaScript.scrollTo(SBOTOP.Casino.pragmatic);
        Waiting.fewSeconds(3);

        Drivers.hoverToElement(SBOTOP.Casino.pragmatic);
        Events.click(SBOTOP.Casino.pragmaticButton);

        try{

            Waiting.element(SBOTOP.Casino.redirection, 10);
            Events.click(SBOTOP.Casino.redirection);

        }catch (Exception ignore){}


        Drivers.changeWindow();

        Waiting.fewSeconds(5);
        System.out.println(driver.getTitle());
    }

    @When("Click {string} Navigator")
    public void clickNavigator(String category) {

        Waiting.element(SBOTOP.PragmaticNav.nav, 30);

        Component tablesComponent;

        switch (category){
            case "Baccarat" -> tablesComponent = SBOTOP.PragmaticNav.baccarat;
            case "Roulette" -> tablesComponent = SBOTOP.PragmaticNav.roulette;
            case "Game Shows" -> tablesComponent = SBOTOP.PragmaticNav.gameShows;
            case "Sic Bo" -> tablesComponent = SBOTOP.PragmaticNav.sicBo;
            case "Dragon Tiger" -> tablesComponent = SBOTOP.PragmaticNav.dragonTiger;
            default -> tablesComponent = SBOTOP.PragmaticNav.andarBahar;
        }

        Events.click(tablesComponent);


    }

    @Then("Verify Pragmatic {string} Tables")
    public void verifyPragmaticTables(String game) throws IOException {

        Component tablesComponent;

        switch (game){
            case "Baccarat" -> tablesComponent = SBOTOP.PragmaticNav.baccaratTables;
            case "Roulette" -> tablesComponent = SBOTOP.PragmaticNav.rouletteTables;
            case "Game Shows" -> tablesComponent = SBOTOP.PragmaticNav.showGamesTables;
            case "Sic Bo" -> tablesComponent = SBOTOP.PragmaticNav.sicBoTables;
            case "Dragon Tiger" -> tablesComponent = SBOTOP.PragmaticNav.dragonTigerTables;
            default -> tablesComponent = SBOTOP.PragmaticNav.andarBaharTables;
        }
        Waiting.fewSeconds(3);

        List<String> tableList = new ArrayList<>();
        List<WebElement> tables = driver.findElements(By.xpath(tablesComponent.getPath()));

        for(WebElement element : tables){

            JavaScript.scrollTo(element);
            System.out.println(element.getText());
            tableList.add(element.getText());
        }

        System.out.println("===========");
        System.out.println(tableList.size());
        System.out.println("==============================");

        File.readExcelFile(game, "Pragmatic");

        List<String> excelList = File.gameList;

        for(String excel : excelList){

            System.out.println(excel);
        }

    }
}

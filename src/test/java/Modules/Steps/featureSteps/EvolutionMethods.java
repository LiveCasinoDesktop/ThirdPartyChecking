package Modules.Steps.featureSteps;

import Modules.Pages.EvolutionComponents;
import Modules.Pages.SBOTOP;
import Utilities.Helper.JavaScript;
import Utilities.Helper.Waiting;
import Utilities.Listeners.Events;
import Utilities.Objects.Component;
import engine.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class EvolutionMethods extends Driver {

    public static List<String> tableList;

    public static void clickNavigator(String category){

        Waiting.element(SBOTOP.Navigation.logo, 30);

        Component component = switch (category) {
            case "Baccarat & Sic Bo" -> SBOTOP.Navigation.baccarat_SicBo;
            case "Poker" -> SBOTOP.Navigation.poker;
            case "Game Shows" -> SBOTOP.Navigation.gameShows;
            default -> SBOTOP.Navigation.roulette;
        };

        Waiting.element(component, 30);

        Waiting.fewSeconds(3);
        Events.click(component);

    }

    public static void verify(String category) {

        Waiting.element(EvolutionComponents.activeNav, 30);
        Waiting.fewSeconds(5);

        Component tablesComponent;

        switch (category){

            case "Roulette" -> tablesComponent = EvolutionComponents.Roulette.rouletteTables;
            case "Poker" -> tablesComponent = EvolutionComponents.Poker.pokerTables;
            case "Game Shows" -> tablesComponent = EvolutionComponents.GameShows.gameShows;
            default -> tablesComponent = EvolutionComponents.Baccarat_SicBo.baccaratTables;

        }

        Waiting.fewSeconds(2);

        tableList = new ArrayList<>();
        List<WebElement> tables = driver.findElements(By.xpath(tablesComponent.getPath()));

        System.out.println("Table Size: " + tables.size());

        JavaScript.scrollTo(tables, tables.size());

        Waiting.fewSeconds(2);

        tables = driver.findElements(By.xpath(tablesComponent.getPath()));
        System.out.println("Table Size: " + tables.size());

        // * CUTTING THE POPULATION

        for(WebElement element : tables){

            System.out.println(element.getText());
            tableList.add(element.getText());
        }

        System.out.println("===========");
        System.out.println(tableList.size());
        System.out.println("==============================");

    }

}

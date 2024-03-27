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

public class SexyMethods extends Driver {
    public static List<String> tableList;

    public static void clickNavigator(String category){

        Waiting.element(SBOTOP.Navigation.logo, 30);

        Component component = switch (category) {
            case "Baccarat" -> SBOTOP.SexyNav.Navigation.baccarat;
            case "Dragon Tiger" -> SBOTOP.SexyNav.Navigation.dragonTiger;
            case "Dice" -> SBOTOP.SexyNav.Navigation.dice;
            default -> SBOTOP.SexyNav.Navigation.roulette;
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

            case "Baccarat" -> tablesComponent = SBOTOP.SexyNav.baccaratTables;
            case "Dragon Tiger" -> tablesComponent = SBOTOP.SexyNav.dragonTigerTables;
            case "Dice" -> tablesComponent = SBOTOP.SexyNav.diceTables;
            default -> tablesComponent = SBOTOP.SexyNav.rouletteTables;

        }

        tableList = new ArrayList<>();
        List<WebElement> tables = driver.findElements(By.xpath(tablesComponent.getPath()));

        for(WebElement element : tables){

            JavaScript.scrollTo(element);
            tableList.add(element.getText());
        }

        System.out.println("===========");
        System.out.println(tableList.size());
        System.out.println("==============================");

    }

}

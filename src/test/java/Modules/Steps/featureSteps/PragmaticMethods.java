package Modules.Steps.featureSteps;

import Modules.Pages.Pragmatic;
import Utilities.Helper.JavaScript;
import Utilities.Helper.Waiting;
import Utilities.Objects.Component;
import engine.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class PragmaticMethods extends Driver {

    public static List<String> tableList;

    public static void verify(String category) {

        Waiting.element(Pragmatic.Navigation.logo, 30);

        Waiting.fewSeconds(5);

        Component tablesComponent = switch (category){

            case "Baccarat" -> Pragmatic.baccaratTables;
            case "Roulette" -> Pragmatic.rouletteTables;
            case "Game Shows" -> Pragmatic.showGamesTables;
            case "Sic Bo" -> Pragmatic.sicBoTables;
            case "Dragon Tiger" -> Pragmatic.dragonTigerTables;
            default -> Pragmatic.andarBaharTables;

        };


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

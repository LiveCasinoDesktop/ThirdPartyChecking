package Modules.Steps.featureSteps;

import Modules.Pages.SBOTOP;
import Utilities.Helper.JavaScript;
import Utilities.Helper.Waiting;
import Utilities.Listeners.Events;
import Utilities.Listeners.FileEvent;
import Utilities.Objects.Component;
import engine.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PragmaticMethods extends Driver {

    public static List<String> tableList;
    public static Component tablePath;

    public static void clickNavigator(String category){

        Waiting.element(SBOTOP.PragmaticNav.nav, 60);

        Component tablesComponent;

        switch (category){
            case "Baccarat" -> {
                tablesComponent = SBOTOP.PragmaticNav.baccarat;
                tablePath = SBOTOP.PragmaticNav.baccaratTables;
            }
            case "Roulette" -> {
                tablesComponent = SBOTOP.PragmaticNav.roulette;
                tablePath = SBOTOP.PragmaticNav.rouletteTables;
            }
            case "Game Shows" -> {
                tablesComponent = SBOTOP.PragmaticNav.gameShows;
                tablePath = SBOTOP.PragmaticNav.showGamesTables;
            }
            case "Sic Bo" -> {
                tablesComponent = SBOTOP.PragmaticNav.sicBo;
                tablePath = SBOTOP.PragmaticNav.sicBoTables;
            }
            case "Dragon Tiger" -> {
                tablesComponent = SBOTOP.PragmaticNav.dragonTiger;
                tablePath = SBOTOP.PragmaticNav.dragonTigerTables;
            }
            default -> {
                tablesComponent = SBOTOP.PragmaticNav.andarBahar;
                tablePath = SBOTOP.PragmaticNav.andarBaharTables;
            }
        }

        Events.click(tablesComponent);

    }


    public static void verify(String category) throws IOException {

        Waiting.fewSeconds(3);

        tableList = new ArrayList<>();
        List<WebElement> tables = driver.findElements(By.xpath(tablePath.getPath()));

        for(WebElement element : tables){

            JavaScript.scrollTo(element);
            tableList.add(element.getText());
        }

        System.out.println("===========");
        System.out.println(tableList.size());
        System.out.println("==============================");

        FileEvent.readExcel(category, "Pragmatic");


    }
}

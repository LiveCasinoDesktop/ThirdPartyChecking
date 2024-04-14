package Modules.Steps.featureSteps;

import Modules.Pages.EvolutionComponents;
import Modules.Pages.SBOTOP;
import Utilities.Helper.Drivers;
import Utilities.Helper.JavaScript;
import Utilities.Helper.Waiting;
import Utilities.Listeners.Events;
import Utilities.Objects.Component;
import engine.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class SexyMethods extends Driver {
    public static List<String> tableList;

    public static void clickNavigator(String category){

        try{

            JavaScript.click(SBOTOP.SexyNav.closeBanner);
        }catch (Exception e){

            Drivers.refresh();
            JavaScript.click(SBOTOP.SexyNav.closeBanner);
        }
        Waiting.fewSeconds(3);

        Component component = switch (category) {
            case "Baccarat" -> SBOTOP.SexyNav.Navigation.baccarat;
            case "Dragon Tiger" -> SBOTOP.SexyNav.Navigation.dragonTiger;
            case "Dice" -> SBOTOP.SexyNav.Navigation.dice;
            default -> SBOTOP.SexyNav.Navigation.roulette;
        };

        try{
            Waiting.element(component, 30);

        }catch (Exception e){
            Drivers.refresh();
            Waiting.element(component, 30);
        }

        Waiting.fewSeconds(3);
        JavaScript.click(component);

    }

    public static void verify(String category) {

        System.out.println("====================================================");
        System.out.println("=================== VERIFICATION ===================");
        System.out.println("====================================================");
        Waiting.fewSeconds(5);

        Component tablesComponent, nonMaintenance;

        switch (category){

            case "Baccarat" -> tablesComponent = SBOTOP.SexyNav.baccaratTables;
            case "Dragon Tiger" -> tablesComponent = SBOTOP.SexyNav.dragonTigerTables;
            case "Dice" -> tablesComponent = SBOTOP.SexyNav.diceTables;
            default -> tablesComponent = SBOTOP.SexyNav.rouletteTables;

        }

        switch (category){

            case "Baccarat" -> nonMaintenance = SBOTOP.SexyNav.baccaratNonMaintenance;
            case "Dragon Tiger" -> nonMaintenance = SBOTOP.SexyNav.dragonTigerNonMaintenance;
            case "Dice" -> nonMaintenance = SBOTOP.SexyNav.diceNonMaintenance;
            default -> nonMaintenance = SBOTOP.SexyNav.rouletteNonMaintenance;
        }

        tableList = new ArrayList<>();
        List<WebElement> tables = driver.findElements(By.xpath(tablesComponent.getPath()));
        List<WebElement> nonMaintenanceTables = driver.findElements(By.xpath(nonMaintenance.getPath()));

        String tableName;

        for(WebElement element : nonMaintenanceTables){

            JavaScript.scrollTo(element);
            tableName = element.getText();

            if(!tableName.isEmpty()){

                tableList.add(element.getText());
            }
        }
        for(WebElement element : tables){

            JavaScript.scrollTo(element);
            tableName = element.getText();
            if(!tableName.isEmpty()){

                String table = element.getText();
                String[] tableArr = table.split("Maintenance");

                table = tableArr[0];
                tableArr = table.split("\n");

                table = tableArr[0];

                tableArr = table.split(" ");

                table = tableArr[0].concat(tableArr[1]);
                System.out.println(table);

                tableList.add(table);
            }
        }

        System.out.println("===========");
        System.out.println(tableList.size());
        System.out.println("==============================");

        for(String element : tableList){

            System.out.println(element);
        }


    }

}

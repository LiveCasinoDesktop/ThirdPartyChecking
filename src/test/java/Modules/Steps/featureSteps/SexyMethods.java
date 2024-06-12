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
import java.util.Arrays;
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
            Waiting.element(component, 20);

        }catch (Exception e){
            Drivers.refresh();
            Waiting.element(component, 20);
        }

        Waiting.fewSeconds(3);
        JavaScript.click(component);

    }

    public static void verify(String category) {

        System.out.println("====================================================");
        System.out.println("=================== VERIFICATION ===================");
        System.out.println("====================================================");
        Waiting.fewSeconds(5);

        Component tablesComponent, maintenanceTables;

        maintenanceTables = maintenance(category);
        tablesComponent = tablesComponent(category);

        tableList = new ArrayList<>();
        List<WebElement> notNormalTables = driver.findElements(By.xpath(maintenanceTables.getPath()));
        List<WebElement> normalTables = driver.findElements(By.xpath(tablesComponent.getPath()));

        String tableName;

        for(WebElement element : normalTables){

            JavaScript.scrollTo(element);
            tableName = element.getText();

            if(!tableName.isEmpty()){

//                System.out.println("Table name: " + tableName);
                JavaScript.scrollTo(element);
                tableList.add(tableName);

            }
        }

        System.out.println("-------------------------");
        for(WebElement element : notNormalTables){

            JavaScript.scrollTo(element);
            tableName = element.getText();

            if(tableName.contains("Maintenance")){

                String table = element.getText();

                if(!table.isEmpty()){
                    String[] tableArr;

                    String offTable = "", finalTable;

                    tableArr = table.split("Maintenance");

                    for(String mainString : tableArr){

                        String[] string;
                        string = mainString.split("\n");

                        System.out.println(String.join(" ", string));
                        tableList.add(String.join(" ", string));

                    }
                }
            }
        }
//        for(WebElement element : tables){
//
//            tableName = element.getText();
//            if(!tableName.isEmpty()){
//
//                String table = element.getText();
//                String[] tableArr = table.split("Maintenance");
//
//                table = tableArr[0];
//                tableArr = table.split("\n");
//
//                table = tableArr[0];
//
//                tableArr = table.split(" ");
//
//                table = tableArr[0].concat(tableArr[1]);
//                System.out.println(table);
//
////                tableList.add(table);
//            }
//        }

    }
    private static Component tablesComponent(String category){

        return switch (category){
            case "Baccarat" -> SBOTOP.SexyNav.baccaratNonMaintenance;
            case "Dragon Tiger" -> SBOTOP.SexyNav.dragonTigerNonMaintenance;
            case "Dice" -> SBOTOP.SexyNav.diceNonMaintenance;
            default -> SBOTOP.SexyNav.rouletteNonMaintenance;
        };
    }

    private static Component maintenance(String category){

        return switch (category){

            case "Baccarat" -> SBOTOP.SexyNav.baccaratTables;
            case "Dragon Tiger" -> SBOTOP.SexyNav.dragonTigerTables;
            case "Dice" -> SBOTOP.SexyNav.diceTables;
            default -> SBOTOP.SexyNav.rouletteTables;

        };
    }

}

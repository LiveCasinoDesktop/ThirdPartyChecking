package Modules.Steps;

import Modules.Pages.SBOTOP;
import Modules.Pages.Sexy;
import Modules.Steps.featureSteps.SexyMethods;
import Utilities.Helper.Drivers;
import Utilities.Helper.JavaScript;
import Utilities.Helper.JsonFormatter;
import Utilities.Helper.Waiting;
import Utilities.Listeners.JsonGenerator;
import Utilities.Objects.Component;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.And;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class SexyGaming {

    List<Map<String, Object>> information = new ArrayList<>();
    public String product, provider;
    List<String> tableList, lobbyList, fileList;
    @And("Get All {string} Tables of Sexy Gaming")
    public void getAllTablesOfSexyGaming(String category) {

        provider = "SexyGaming";

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
            System.out.println("Waiting for Element");
            Waiting.element(component, 30);

        }catch (Exception e){
            Drivers.refresh();
            try{

                System.out.println("Re Trying...");
                Waiting.element(SBOTOP.SexyNav.closeBanner, 40);
                JavaScript.click(SBOTOP.SexyNav.closeBanner);
                Waiting.element(component, 40);
            }catch (Exception ignore){}

        }

        try{

            System.out.println("Changing iFrame...");
            Drivers.changeIFrame(Sexy.IFrame.gameHall);
            System.out.println("Re Trying...");
            //Waiting.element(SBOTOP.SexyNav.closeBanner, 40);
            JavaScript.click(SBOTOP.SexyNav.closeBanner);
            //Waiting.element(component, 40);
        }catch (Exception ignore){}

        Waiting.fewSeconds(3);
        JavaScript.click(component);

    }

    @And("Verify {string} of Sexy Gaming")
    public void verifyOfSexyGaming(String category) throws IOException {

        fileList = new ArrayList<>();
        lobbyList = new ArrayList<>();

        switch (category){

            case "Baccarat" -> product = "Baccarat";
            case "Dragon Tiger" -> product = "Dragon Tiger";
            case "Dice" -> product = "Dice";
            default -> product = "Roulette";
        }


        SexyMethods.verify(category);

        tableList = SexyMethods.tableList;

        System.out.println("=======================");
        System.out.println("Left Join Verification");
        for(String table : SexyMethods.tableList){

            if(!tableList.contains(table)){

                System.out.println("Excel List have no: " + table);
                fileList.add(table);
            }
        }

        System.out.println("=======================");
        System.out.println("Right Join Verification");
        for(String table : tableList){

            if(!SexyMethods.tableList.contains(table)){

                System.out.println("Game Lobby have no: " + table);
                lobbyList.add(table);
            }
        }

        createJSON();
    }

    private void createJSON() throws IOException {

        System.out.println("================================");
        System.out.println("================================");
        System.out.println("================================");

        information.add(JsonGenerator.generate(product, tableList, fileList, lobbyList));
    }


    @And("Display JSON Sexy Gaming")
    public void displayJSONSexyGaming() throws IOException {

        JsonFormatter.generate(information, provider);

    }
}

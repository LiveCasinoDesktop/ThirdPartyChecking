package Modules.Steps;

import Modules.Pages.SBOTOP;
import Modules.Steps.featureSteps.SexyMethods;
import Utilities.Helper.Drivers;
import Utilities.Helper.JavaScript;
import Utilities.Helper.JsonFormatter;
import Utilities.Helper.Waiting;
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
            Waiting.element(component, 30);

        }catch (Exception e){
            Drivers.refresh();
            try{

                JavaScript.click(SBOTOP.SexyNav.closeBanner);
            }catch (Exception ignore){}
            Waiting.element(component, 40);
        }

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

        List<String> tableList = SexyMethods.tableList;

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



        //Map<String, Object> existing = information(fileName);

        Map<String, Object> data = new LinkedHashMap<>();
        data.put("category", product);
        data.put("fileList", fileList);
        data.put("lobbyList", lobbyList);
        ObjectMapper mapper = new ObjectMapper();
        String jsonData = mapper.writeValueAsString(data);
        System.out.println(jsonData);
        System.out.println("================================");
        System.out.println("================================");
        System.out.println("================================");

        information.add(data);

    }


    @And("Display JSON Sexy Gaming")
    public void displayJSONSexyGaming() throws IOException {

        JsonFormatter.generate(information, provider);

    }
}

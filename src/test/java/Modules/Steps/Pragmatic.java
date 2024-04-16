package Modules.Steps;

import Modules.Steps.featureSteps.PragmaticMethods;
import Utilities.Helper.JsonFormatter;
import Utilities.Helper.Waiting;
import Utilities.Listeners.Events;
import Utilities.Listeners.FileEvent;
import Utilities.Listeners.JsonGenerator;
import Utilities.Objects.Component;
import engine.Driver;
import io.cucumber.java.en.And;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Pragmatic extends Driver {

    List<Map<String, Object>> information = new ArrayList<>();
    public String product, provider;
    List<String> tableList, lobbyList, fileList;

    @And("Get All {string} Tables of Pragmatic")
    public void getAllTablesOfPragmatic(String category) throws IOException {

        provider = "Pragmatic";
        String activeCategory = Events.getText(Modules.Pages.Pragmatic.Navigation.active);

        Component component = switch (category){

            case "Baccarat" -> Modules.Pages.Pragmatic.Navigation.baccarat;
            case "Roulette" -> Modules.Pages.Pragmatic.Navigation.roulette;
            case "Game Shows" -> Modules.Pages.Pragmatic.Navigation.gameShows;
            case "Sic Bo" -> Modules.Pages.Pragmatic.Navigation.sicBo;
            case "Dragon Tiger" -> Modules.Pages.Pragmatic.Navigation.dragonTiger;
            default -> Modules.Pages.Pragmatic.Navigation.andarBahar;

        };

        if(!activeCategory.equals(category)){

            Waiting.fewSeconds(2);
            Events.click(component);
        }

        FileEvent.readExcel(category, provider);
        tableList = FileEvent.gameList;

        System.out.println("===============");
        System.out.println("Excel File Table List");
        System.out.println("Table Size: " + tableList.size());
        System.out.println("===============");
        for(String table : tableList){

            System.out.println(table);
        }
        System.out.println("============================================================");
        System.out.println("============================================================");

    }

    @And("Verify {string} of Pragmatic")
    public void verifyOfPragmatic(String category) throws IOException {

        fileList = new ArrayList<>();
        lobbyList = new ArrayList<>();

        switch (category){

            case "Baccarat" -> product = "Baccarat";
            case "Roulette" -> product = "Roulette";
            case "Game Shows" -> product = "Game Shows";
            case "Sic Bo" -> product = "Sic Bo";
            case "Dragon Tiger" -> product = "Dragon Tiger";
            default -> product = "Andar Bahar";
        }

        //EvolutionMethods.clickNavigator(category);
        PragmaticMethods.verify(category);

        System.out.println("=======================");
        System.out.println("Left Join Verification");
        for(String table : PragmaticMethods.tableList){

            if(!tableList.contains(table)){

                System.out.println("Excel List have no: " + table);
                fileList.add(table);
            }
        }

        System.out.println("=======================");
        System.out.println("Right Join Verification");
        for(String table : tableList){

            if(!tableList.contains(table)){

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

    @And("Display JSON Pragmatic")
    public void displayJSONPragmatic() throws IOException {

        JsonFormatter.generate(information, "Pragmatic");
    }
}

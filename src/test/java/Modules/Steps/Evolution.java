package Modules.Steps;

import Modules.Pages.EvolutionComponents;
import Modules.Steps.featureSteps.EvolutionMethods;
import Utilities.Helper.JsonFormatter;
import Utilities.Helper.Waiting;
import Utilities.Listeners.Events;
import Utilities.Listeners.FileEvent;
import Utilities.Listeners.JsonGenerator;
import Utilities.Objects.Component;
import com.fasterxml.jackson.databind.ObjectMapper;
import engine.Driver;
import io.cucumber.java.en.And;

import java.io.IOException;
import java.util.*;

public class Evolution extends Driver {

    List<Map<String, Object>> information = new ArrayList<>();
    public String product, provider;
    List<String> tableList, lobbyList, fileList;
    @And("Get All {string} Tables of Evolution")
    public void getAllTablesOfEvolution(String category) throws IOException {

        provider = "Evolution";
        String activeCategory = Events.getText(EvolutionComponents.navigation);

        Component component = switch (category){

            case "Roulette" -> EvolutionComponents.Navigation.roulette;
            case "Baccarat & Sic Bo" -> EvolutionComponents.Navigation.baccarat_SicBo;
            case "Poker" -> EvolutionComponents.Navigation.poker;
            default -> EvolutionComponents.Navigation.gameShows;

        };

        if(!activeCategory.equals(category)){

            Waiting.fewSeconds(2);
            Events.click(EvolutionComponents.logo);

            Waiting.fewSeconds(2);
            Events.click(EvolutionComponents.games);

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

    @And("Verify {string} of Evolution")
    public void verifyOfEvolution(String category) throws IOException {

        fileList = new ArrayList<>();
        lobbyList = new ArrayList<>();

        switch (category){

            case "Baccarat & Sic Bo" -> product = "Baccarat & Sic Bo";
            case "Roulette" -> product = "Roulette";
            case "Poker" -> product = "Poker";
            default -> product = "Game Shows";
        }

        EvolutionMethods.verify(category);

        System.out.println("=======================");
        System.out.println("Left Join Verification");
        for(String table : EvolutionMethods.tableList){

            if(!tableList.contains(table)){

                System.out.println("Excel List have no: " + table);
                fileList.add(table);
            }
        }

        System.out.println("=======================");
        System.out.println("Right Join Verification");
        for(String table : tableList){

            if(!EvolutionMethods.tableList.contains(table)){

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
    @And("Display JSON {string}")
    public void displayJSON(String provider) throws IOException {
        JsonFormatter.generate(information, provider);
    }
}

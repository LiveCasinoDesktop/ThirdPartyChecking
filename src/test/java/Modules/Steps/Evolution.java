package Modules.Steps;

import Modules.Pages.EvolutionComponents;
import Modules.Steps.featureSteps.EvolutionMethods;
import Utilities.Helper.JsonFormatter;
import Utilities.Helper.Waiting;
import Utilities.Listeners.Events;
import Utilities.Listeners.FileEvent;
import Utilities.Listeners.JsonGenerator;
import Utilities.Listeners.SendEmail;
import Utilities.Objects.Component;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import engine.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;
import java.util.*;

public class Evolution extends Driver {

    List<Map<String, Object>> information = new ArrayList<>();
    public String product, provider;
    List<String> tableList, lobbyList, fileList, addedTimeStamp, removedTimeStamp;

    // ? ====================================================================
    // ? ====================================================================
    // ? ====================================================================
    // ? ====================================================================


    @When("Try to get All {string} Tables of Evolution")
    public void tryToGetAllTablesOfEvolution(String category) throws IOException {

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

        for(String table : tableList){

            System.out.println(table);
        }
        System.out.println("============================================================");
        System.out.println("============================================================");

    }

    @Then("Verify {string} of Provider Evolution")
    public void verifyOfProviderEvolution(String category) throws IOException {

        fileList = new ArrayList<>();
        lobbyList = new ArrayList<>();
        addedTimeStamp = new ArrayList<>();
        removedTimeStamp = new ArrayList<>();

        switch (category){

            case "Baccarat & Sic Bo" -> product = "Baccarat & Sic Bo";
            case "Roulette" -> product = "Roulette";
            case "Poker" -> product = "Poker";
            default -> product = "Game Shows";
        }

        EvolutionMethods.verify(category);
        System.out.println("Total Table In Lobby: " + EvolutionMethods.tableList.size());

        System.out.println("=======================");
        System.out.println("Left Join Verification");
        for(String table : EvolutionMethods.tableList){

            if(!tableList.contains(table)){

                System.out.println("Excel List have no: " + table);
                fileList.add(table);
                String timeStamp = Events.FORMATTER.timeFormat();
                addedTimeStamp.add(timeStamp);
            }
        }

        System.out.println("=======================");
        System.out.println("Right Join Verification");
        for(String table : tableList){

            if(!EvolutionMethods.tableList.contains(table)){

                System.out.println("Game Lobby have no: " + table);
                lobbyList.add(table);
                String timeStamp = Events.FORMATTER.timeFormat();
                removedTimeStamp.add(timeStamp);
            }
        }


//        if(!fileList.isEmpty() || !lobbyList.isEmpty()){
//
//            information.add(JsonGenerator.generate(product, tableList, fileList, addedTimeStamp, lobbyList, removedTimeStamp));
//            JsonFormatter.generate(information, provider);
//            SendEmail.sendSpecific(provider);
//
//        }
//        else{
//
            information.add(JsonGenerator.generate(product, tableList, fileList, addedTimeStamp, lobbyList, removedTimeStamp));
            JsonFormatter.generate(information, provider);
//        }
    }
}

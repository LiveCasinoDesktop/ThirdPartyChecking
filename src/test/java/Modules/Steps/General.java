package Modules.Steps;

import Modules.Pages.EvolutionComponents;
import Modules.Pages.SBOTOP;
import Modules.Pages.Sexy;
import Modules.Steps.featureSteps.EvolutionMethods;
import Modules.Steps.featureSteps.PragmaticMethods;
import Modules.Steps.featureSteps.SexyMethods;
import Utilities.Helper.Drivers;
import Utilities.Helper.Waiting;
import Utilities.Listeners.Events;
import Utilities.Listeners.FileEvent;
import Utilities.Listeners.SendEmail;
import Utilities.Objects.Component;
import Utilities.Settings.Constants;
import engine.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class General extends Driver {

    String provider, category;
    Component thirdPartyComponent, componentButton;
    List<String> tableList, lobbyList, fileList;
    String product;
    String timeStamp;
    @When("I Go To SBOTOP")
    public void iGoToSBOTOP() {

    }
    @And("Login Account")
    public void loginAccount() {
        driver.get(Constants.URL);

        Waiting.fewSeconds(5);

        Waiting.element(SBOTOP.Landing.user, 30);
        Events.sendKeys(SBOTOP.Landing.user, Constants.Accounts.IDR.username);
        Waiting.fewSeconds(3);

        Waiting.element(SBOTOP.Landing.pass, 30);
        Events.sendKeys(SBOTOP.Landing.pass, Constants.Accounts.IDR.password);
        Waiting.fewSeconds(3);

        Waiting.element(SBOTOP.Landing.login, 30);
        Events.click(SBOTOP.Landing.login);
        Waiting.fewSeconds(3);

        Waiting.element(SBOTOP.Landing.accountName, 30);

        try{

            Waiting.element(SBOTOP.Landing.banner, 10);
            Events.click(SBOTOP.Landing.banner);

        }catch (Exception ignore){}

        Waiting.element(SBOTOP.Landing.liveCasino, 10);
        Events.click(SBOTOP.Landing.liveCasino);


        try{
            Waiting.element(SBOTOP.Casino.promotionClose, 30);
            Events.click(SBOTOP.Casino.promotionClose);

        }catch (Exception ignore){}

        Waiting.element(SBOTOP.Casino.thirdParty, 20);

    }
    @When("I Join {string} Casino")
    public void iJoinCasino(String thirdParty) {

        if(thirdParty.equals("Evolution")){

            thirdPartyComponent = SBOTOP.Casino.evolution;
            componentButton = SBOTOP.Casino.evolutionButton;
        }
        else if(thirdParty.equals("Sexy")){

            thirdPartyComponent = SBOTOP.Casino.sexy;
            componentButton = SBOTOP.Casino.sexyButton;
        }
        else{
            thirdPartyComponent = SBOTOP.Casino.pragmatic;
            componentButton = SBOTOP.Casino.pragmaticButton;
        }

        Waiting.fewSeconds(3);

        clickThirdParty();

        Waiting.fewSeconds(3);
        Drivers.changeWindow();

        Drivers.maximize();


        if(thirdParty.equals("Evolution")){

            System.out.println("Changing iFrame...");
            Drivers.changeIFrame(EvolutionComponents.iframe);
        }
        else if(thirdParty.equals("Sexy")){

            Waiting.fewSeconds(2);

            Drivers.refresh();

            try{

                Waiting.element(Sexy.IFrame.gameHall, 20);
            }catch (Exception e){

                Drivers.refresh();

                try{
                    Waiting.element(Sexy.IFrame.gameHall, 30);
                }catch (Exception f){

                    driver.close();
                    Drivers.selectOriginalWindow();
                    clickThirdParty();
                    Drivers.changeWindow();
                }
            }

            System.out.println("Changing iFrame...");
            Drivers.changeIFrame(Sexy.IFrame.gameHall);

        }


    }
    @When("Get All Table Names of {string} of {string}")
    public void getAllTableNamesOfOf(String category, String thirdParty) throws IOException {

        FileEvent.readExcel(category, thirdParty);
        tableList = FileEvent.gameList;

        provider = thirdParty;
        this.category = category;

        System.out.println("===============");
        System.out.println("Excel File Table List");
        System.out.println("Table Size: " + tableList.size());
        System.out.println("===============");
        for(String table : tableList){

            System.out.println(table);
        }
        System.out.println("============================================================");
        System.out.println("============================================================");
        System.out.println("============================================================");
    }


    @Then("Verify {string} of {string}")
    public void verifyOf(String category, String thirdParty) throws IOException {

        timeStamp = Events.FORMATTER.timeFormat();

        lobbyList = new ArrayList<>();
        fileList = new ArrayList<>();

        if(thirdParty.equals("Pragmatic")){

            switch (category){

                case "Baccarat" -> product = "Baccarat";
                case "Roulette" -> product = "Roulette";
                case "Game Shows" -> product = "Game Shows";
                case "Sic Bo" -> product = "Sic Bo";
                case "Dragon Tiger" -> product = "Dragon Tiger";
                default -> product = "Andar Bahar";
            }

            //PragmaticMethods.clickNavigator(category);
            //PragmaticMethods.verify(category);

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

                if(!PragmaticMethods.tableList.contains(table)){

                    System.out.println("Game Lobby have no: " + table);
                    lobbyList.add(table);
                }
            }

        }
        else if(thirdParty.equals("Sexy")){

            switch (category){

                case "Baccarat" -> product = "BC";
                case "Dragon Tiger" -> product = "DT";
                case "Dice" -> product = "DC";
                default -> product = "RL";
            }

            SexyMethods.clickNavigator(category);
            SexyMethods.verify(category);

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
        }
        else{

            switch (category){

                case "Baccarat & Sic Bo" -> product = "BS";
                case "Roulette" -> product = "RL";
                case "Poker" -> product = "PK";
                default -> product = "GS";
            }

            EvolutionMethods.clickNavigator(category);
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
        }
    }


    private void clickThirdParty(){

        Waiting.element(thirdPartyComponent, 10);

        Drivers.hoverToElement(thirdPartyComponent);
        Waiting.fewSeconds(3);
        Events.click(componentButton);


        try{

            Waiting.element(SBOTOP.Casino.redirection, 10);
            Events.click(SBOTOP.Casino.redirection);

        }catch (Exception ignore){}
    }

    @Then("Send Email")
    public void sendEmail() {

        try{

            SendEmail.send();
        }catch (Exception e){

            SendEmail.send();
        }
    }

}

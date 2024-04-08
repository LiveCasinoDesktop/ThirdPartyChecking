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
import Utilities.Listeners.File;
import Utilities.Objects.Component;
import Utilities.Settings.Constants;
import engine.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;
import java.util.List;

public class General extends Driver {

    List<String> tableList;
    @When("I Go To SBOTOP")
    public void iGoToSBOTOP() {

        driver.get(Constants.URL);
    }

    @And("Login Account")
    public void loginAccount() {

        Waiting.element(SBOTOP.Landing.user, 30);
        Events.sendKeys(SBOTOP.Landing.user, Constants.Accounts.IDR.username);

        Waiting.element(SBOTOP.Landing.pass, 30);
        Events.sendKeys(SBOTOP.Landing.pass, Constants.Accounts.IDR.password);

        Waiting.element(SBOTOP.Landing.login, 30);
        Events.click(SBOTOP.Landing.login);

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

        Component thirdPartyComponent, componentButton;
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

        Waiting.element(thirdPartyComponent, 10);

        Drivers.hoverToElement(thirdPartyComponent);
        Waiting.fewSeconds(3);
        Events.click(componentButton);

        try{

            Waiting.element(SBOTOP.Casino.redirection, 10);
            Events.click(SBOTOP.Casino.redirection);

        }catch (Exception ignore){}

        Waiting.fewSeconds(3);
        Drivers.changeWindow();


        if(thirdParty.equals("Evolution")){

            System.out.println("Changing iFrame...");
            Drivers.changeIFrame(EvolutionComponents.iframe);
        }
        else if(thirdParty.equals("Sexy")){

            try{

                Waiting.element(Sexy.IFrame.gameHall, 20);
            }catch (Exception e){

                Drivers.refresh();
                Waiting.element(Sexy.IFrame.gameHall, 60);
            }

            System.out.println("Changing iFrame...");
            Drivers.changeIFrame(Sexy.IFrame.gameHall);

        }


    }
    @When("Get All Table Names of {string} of {string}")
    public void getAllTableNamesOfOf(String category, String thirdParty) throws IOException {

        File.readExcel(category, thirdParty);
        tableList = File.gameList;

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

        if(thirdParty.equals("Pragmatic")){

            PragmaticMethods.clickNavigator(category);
            PragmaticMethods.verify(category);

            System.out.println("=======================");
            System.out.println("Left Join Verification");
            for(String table : PragmaticMethods.tableList){

                if(!tableList.contains(table)){

                    System.out.println("Excel List have no: " + table);
                }
            }
            System.out.println("=======================");
            System.out.println("Right Join Verification");

            for(String table : tableList){

                if(!PragmaticMethods.tableList.contains(table)){

                    System.out.println("Game Lobby have no: " + table);
                }
            }

        }
        else if(thirdParty.equals("Sexy")){


            SexyMethods.clickNavigator(category);
            SexyMethods.verify(category);

            System.out.println("=======================");
            System.out.println("Left Join Verification");
            for(String table : SexyMethods.tableList){

                if(!tableList.contains(table)){

                    System.out.println("Excel List have no: " + table);
                }
            }
            System.out.println("=======================");
            System.out.println("Right Join Verification");

            for(String table : tableList){

                if(!SexyMethods.tableList.contains(table)){

                    System.out.println("Game Lobby have no: " + table);
                }
            }
        }
        else{

            EvolutionMethods.clickNavigator(category);
            EvolutionMethods.verify(category);

            System.out.println("=======================");
            System.out.println("Left Join Verification");
            for(String table : EvolutionMethods.tableList){

                if(!tableList.contains(table)){

                    System.out.println("Excel List have no: " + table);
                }
            }

            System.out.println("=======================");
            System.out.println("Right Join Verification");
            for(String table : tableList){

                if(!EvolutionMethods.tableList.contains(table)){

                    System.out.println("Game Lobby have no: " + table);
                }
            }
        }
    }
}

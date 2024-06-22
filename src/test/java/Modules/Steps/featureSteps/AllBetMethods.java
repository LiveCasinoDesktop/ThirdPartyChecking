package Modules.Steps.featureSteps;

import Modules.Pages.AllBet;
import Utilities.Helper.JsonFormatter;
import Utilities.Helper.Waiting;
import Utilities.Listeners.Events;
import Utilities.Listeners.FileEvent;
import Utilities.Listeners.JsonGenerator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AllBetMethods {

    private static List<Map<String, Object>> information = new ArrayList<>();
    private static List<String> lobbyTables, fileTables;
    private static List<String> lobbyList, fileList, addedTimeStamp, removedTimeStamp;


    public static void printAllTables(){

        Waiting.element(AllBet.Tables.tables, 10);
        Waiting.fewSeconds(3);

        List<String> tables = Events.getListText(AllBet.Tables.tables);
        lobbyTables = new ArrayList<>();

        System.out.println(tables.size());
        for(String table : tables){

            String string = table;

            if(table.contains("\n")){

                String[] arr = string.split("\n");
                string = arr[0];

            }

            System.out.println(string);
            lobbyTables.add(string);
        }

        System.out.println("====================================");
        System.out.println("====================================");
    }

    public static void verifyTables(String category) throws IOException {

        FileEvent.readExcel(category, "AllBet");
        fileTables = new ArrayList<>();

        lobbyList = new ArrayList<>();
        fileList = new ArrayList<>();

        addedTimeStamp = new ArrayList<>();
        removedTimeStamp = new ArrayList<>();

        System.out.println("File List: " + FileEvent.gameList.size());

        for(String string : FileEvent.gameList){

            if(!string.isEmpty()){

                System.out.println(string);
                fileTables.add(string);
            }
        }

        /*

        ** JOIN VERIFICATION **

        ** LEFT JOIN - Tables are in List but not in Lobby
        ** RIGHT JOIN - Tables are not in List but in Lobby

         */


        System.out.println("=======================");
        System.out.println("Left Join Verification");
        for(String table : fileTables){

            if(!lobbyTables.contains(table)){

                System.out.println("Excel List have no: " + table);
                fileList.add(table);
                String timeStamp = Events.FORMATTER.timeFormat();
                addedTimeStamp.add(timeStamp);
            }

//            System.out.println("Excel List have no: " + table);
//            fileList.add(table);
//            String timeStamp = Events.FORMATTER.timeFormat();
//            addedTimeStamp.add(timeStamp);
        }

        System.out.println("=======================");
        System.out.println("Right Join Verification");
        for(String table : lobbyTables){

            if(!fileTables.contains(table)){

                System.out.println("Game Lobby have no: " + table);
                lobbyList.add(table);
                String timeStamp = Events.FORMATTER.timeFormat();
                removedTimeStamp.add(timeStamp);
            }


//            System.out.println("Game Lobby have no: " + table);
//            lobbyList.add(table);
//            String timeStamp = Events.FORMATTER.timeFormat();
//            removedTimeStamp.add(timeStamp);

        }

        information.add(JsonGenerator.generate(category, fileTables, fileList, addedTimeStamp, lobbyList, removedTimeStamp));
        JsonFormatter.generate(information, "AllBet");

    }
}

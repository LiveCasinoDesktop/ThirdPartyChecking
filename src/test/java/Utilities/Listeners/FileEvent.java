package Utilities.Listeners;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class FileEvent {

    public static List<String> gameList;

    public static void readExcelFile(String list, String thirdParty) throws IOException {

        XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/Excel/tableList.xlsx"));

        System.out.println("Third Party: " + thirdParty);
        System.out.println("List: " + list);
        XSSFSheet sheet = workbook.getSheet(thirdParty);

        List<String> columnValues = new ArrayList<>();

        int rowLocator = 1; // * ROW COUNTER STARTS AT 1, GAME CATEGORY IS 0
        int columnLocator = getColumnLocator(thirdParty, list);
        System.out.println("Column Locator: " + columnLocator);


        for(int rowIndex = rowLocator; rowIndex <= sheet.getLastRowNum(); rowIndex++){
            XSSFRow row = sheet.getRow(rowIndex);

            if(row.getCell(columnLocator) != null){
                String cellValue = row.getCell(columnLocator).getStringCellValue();
                columnValues.add(cellValue);
            }
        }

        gameList = new ArrayList<>();
        gameList.addAll(columnValues);

        workbook.close();
    }

    private static int getColumnLocator(String thirdParty, String list) {
        int columnLocator;

        if(thirdParty.equals("Evolution")){
            switch (list){

                case "Roulette" -> columnLocator = 0;
                case "Game Shows" -> columnLocator = 1;
                case "Poker" -> columnLocator = 2;
                default -> columnLocator = 3;
            }
        }
        else if(thirdParty.equals("Sexy")){
            switch (list){

                case "Baccarat" -> columnLocator = 0;
                case "Dragon Tiger" -> columnLocator = 1;
                case "Dice" -> columnLocator = 2;
                default -> columnLocator = 3;
            }
        }
        else{
            switch (list){

                case "Baccarat" -> columnLocator = 0;
                case "Roulette" -> columnLocator = 1;
                case "Game Shows" -> columnLocator = 2;
                case "Sic Bo" -> columnLocator = 3;
                case "Dragon Tiger" -> columnLocator = 4;
                default -> columnLocator = 5;
            }
        }
        return columnLocator;
    }

    public static void readExcel(String category, String thirdParty) throws IOException{

        XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/Excel/tableList.xlsx"));

        System.out.println("Third Party: " + thirdParty);
        System.out.println("Category: " + category);

        XSSFSheet sheet = workbook.getSheet(thirdParty);

        List<String> columnValues = new ArrayList<>();

        int rowLocator = 1; // * ROW COUNTER STARTS AT 1, GAME CATEGORY IS 0
        int columnLocator = columnLocator(category, thirdParty);
        System.out.println("Column Locator: " + columnLocator);

        for(int rowIndex = rowLocator; rowIndex <= sheet.getLastRowNum(); rowIndex++){
            XSSFRow row = sheet.getRow(rowIndex);

            if(row.getCell(columnLocator) != null){
                String cellValue = row.getCell(columnLocator).getStringCellValue();
                columnValues.add(cellValue);
            }
        }

        gameList = new ArrayList<>();
        gameList.addAll(columnValues);

        workbook.close();
    }

    private static int columnLocator(String category, String thirdParty){
        int columnLocator;

        if(thirdParty.equals("Evolution")){
            switch (category){

                case "Roulette" -> columnLocator = 0;
                case "Game Shows" -> columnLocator = 1;
                case "Poker" -> columnLocator = 2;
                default -> columnLocator = 3;
            }
        }
        else if(thirdParty.equals("Pragmatic")){
            switch (category){

                case "Baccarat" -> columnLocator = 0;
                case "Roulette" -> columnLocator = 1;
                case "Game Shows" -> columnLocator = 2;
                case "Sic Bo" -> columnLocator = 3;
                case "Dragon Tiger" -> columnLocator = 4;
                default -> columnLocator = 5;
            }
        }
        else{
            switch (category){
                case "Baccarat" -> columnLocator = 0;
                case "Dragon Tiger" -> columnLocator = 1;
                case "Dice" -> columnLocator = 2;
                default -> columnLocator = 3;
            }
        }
        return columnLocator;
    }



    // * ===============================
    // * ===============================
    // * ===============================
    // * ===============================

    public static void generateFile(String provider, String product, List<String> fileList, List<String> lobbyList, String timeStamp){

        try {
            String formattedDate = Events.FORMATTER.dateFormat();

            String path = "listFile/"+formattedDate+"/";

            File fPath = new File(path);

            if (!fPath.exists()) {
                fPath.mkdir();
            }

            FileWriter file = new FileWriter(path +provider + "_" + product + ".txt");

            file.write("Provider: " + provider + "\n");
            file.write("Product: " + product + "\n");
            file.write("Date: " + formattedDate + "\n");
            file.write("Time Started: " + timeStamp + "\n\n\n");

            if(!fileList.isEmpty()){

                file.write("File List: Excel File List Has No...\n");
                for(String fileStr : fileList){

                    System.out.println("Table: " + fileStr);

                    file.write(fileStr+"\n");
                }
                file.write("\n\n\n");
            }
            else{

                file.write("File List: No Issue\n\n");

            }

            if(!lobbyList.isEmpty()){

                file.write("Lobby List: Game Lobby Has No...\n");
                for(String lobbyStr : lobbyList){

                    System.out.println("Table: " + lobbyStr);

                    file.write(lobbyStr+"\n");
                }
            }
            else{

                file.write("Lobby List: No Issue");

            }

            file.close();
            System.out.println("Successfully wrote to the file.");

        } catch (IOException e) {

            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }
}

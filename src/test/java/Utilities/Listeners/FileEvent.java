package Utilities.Listeners;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;

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


    public static void generate(String provider, String product){

        try{

            String formattedDate = Events.FORMATTER.dateFormat();

            String path = "listFile/"+formattedDate+"/"+provider+"/";

            File fPath = new File(path);

            if (!fPath.exists()) {
                fPath.mkdir();
            }

            FileWriter writer = new FileWriter(fPath, true);
            writer.write("\n");

        }catch (IOException e){

            System.err.println("Error writing to file: " + e.getMessage());
        }
    }


    // * ================================== EXCEL FILE
    public static void excel(String provider, String category, List<String> fileList, List<String> lobbyList) throws IOException {

        System.out.println(provider);
        System.out.println(category);

        String fileName = "results.xls";
        Workbook workbook;

        // ? CHECK IF EXCEL FILE EXIST
        // ? IF NO, CREATE. ELSE, SELECT EXCEL
        if(!fileExist(fileName)){
            // Create a new workbook
            workbook = new HSSFWorkbook();
        }
        else{
            workbook = new HSSFWorkbook(new FileInputStream(fileName));
        }

        // ? CHECK IF SHEET NAMED PROVIDER EXIST
        // ? IF NO, CREATE. ELSE, SELECT SHEET
        Sheet sheet;
        if(!sheetExist(workbook, provider)){

            sheet = workbook.createSheet(provider);
        }
        else{

            sheet = workbook.getSheet(provider);
        }

        headingInput(sheet, provider, category);

        valuesInput(sheet, fileList, lobbyList);

        OutputStream outputStream = new FileOutputStream(fileName);
        workbook.write(outputStream);
        workbook.close();

        System.out.println("Excel file generated successfully!");
    }

    private static boolean fileExist(String filePath){

        File file = new File(filePath);
        return file.exists();
    }
    private static boolean sheetExist(Workbook workbook, String sheetName){
        for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
            if (workbook.getSheetName(i).equals(sheetName)) {
                return true;
            }
        }

        return false;
    }

    private static void headingInput(Sheet sheet, String provider, String category){

        Row row;
        Cell fileCell, lobbyCell;

        int fileHead, lobbyHead;

        if(provider.equals("Evolution")){
            switch (category) {
                case "Roulette" -> {
                    fileHead = 0;
                    lobbyHead = 1;
                }
                case "Game Show" -> {
                    fileHead = 3;
                    lobbyHead = 4;
                }
                case "Poker" -> {
                    fileHead = 6;
                    lobbyHead = 7;
                }
                default -> {
                    fileHead = 9;
                    lobbyHead = 10;
                }
            }
        }
        else if(provider.equals("Sexy Gaming")){
            switch (category) {
                case "Baccarat" -> {
                    fileHead = 0;
                    lobbyHead = 1;
                }
                case "Dragon Tiger" -> {
                    fileHead = 3;
                    lobbyHead = 4;
                }
                case "Dice" -> {
                    fileHead = 6;
                    lobbyHead = 7;
                }
                default -> {
                    fileHead = 9;
                    lobbyHead = 10;
                }
            }
        }
        else{
            switch (category) {
                case "Baccarat" -> {
                    fileHead = 0;
                    lobbyHead = 1;
                }
                case "Roulette" -> {
                    fileHead = 3;
                    lobbyHead = 4;
                }
                case "Game Shows" -> {
                    fileHead = 6;
                    lobbyHead = 7;
                }
                case "Sic Bo" -> {
                    fileHead = 9;
                    lobbyHead = 10;
                }
                case "Dragon Tiger" -> {
                    fileHead = 12;
                    lobbyHead = 13;
                }
                default -> {
                    fileHead = 15;
                    lobbyHead = 16;
                }
            }
        }

        row = sheet.createRow(0);
        fileCell = row.createCell(fileHead);
        fileCell.setCellValue("File List:");
        lobbyCell = row.createCell(lobbyHead);
        lobbyCell.setCellValue("Lobby List:");

    }

    private static void valuesInput(Sheet sheet, List<String> fileList, List<String> lobbyList){

        System.out.println("================ EXCEL REPORT");
        int rowInt = 1;

        Row row;
        Cell cell;

        System.out.println("----------- FILE ");

        for(String file : fileList){

            System.out.println(file);
            row = sheet.createRow(rowInt++);
            cell = row.createCell(0);
            cell.setCellValue(file);

        }

        System.out.println("----------- LOBBY ");
        for(String lobby : lobbyList){

            System.out.println(lobby);
            row = sheet.createRow(rowInt++);
            cell = row.createCell(1);
            cell.setCellValue(lobby);
        }
    }
}

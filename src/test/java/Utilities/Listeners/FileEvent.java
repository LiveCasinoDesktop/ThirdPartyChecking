package Utilities.Listeners;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;

import java.util.ArrayList;
import java.util.List;

public class FileEvent {

    public static List<String> gameList;

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

}

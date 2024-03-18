package Utilities.Listeners;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class File {

    public static List<String> gameList;

    public static void readExcelFile(String list, String thirdParty) throws IOException {

        XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/Excel/tableList.xlsx"));

        XSSFSheet sheet = workbook.getSheet(thirdParty);

        List<String> columnValues = new ArrayList<>();

        int rowLocator = 1; // * ROW COUNTER STARTS AT 1, GAME CATEGORY IS 0
        int columnLocator = getColumnLocator(thirdParty, list);


        for(int rowIndex = rowLocator; rowIndex <= sheet.getLastRowNum(); rowIndex++){
            XSSFRow row = sheet.getRow(rowIndex);

            if(row.getCell(columnLocator) != null){
                String cellValue = row.getCell(columnLocator).getStringCellValue();
                columnValues.add(cellValue);
            }
        }

        gameList = new ArrayList<>();

        //System.out.println(value);
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
}

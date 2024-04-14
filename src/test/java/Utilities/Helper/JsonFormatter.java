package Utilities.Helper;


import Utilities.Listeners.Events;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class JsonFormatter {


    static String jsonDirectory = "reports/json/";
    static String excelDirectory = "reports/excel/";
    public static void generate(List<Map<String, Object>> information, String provider) throws IOException {

        String formattedDate = jsonDirectory.concat(Events.FORMATTER.dateFormat());

        File theDir = new File(formattedDate);
        if (!theDir.exists()){
            theDir.mkdirs();
        }

        String fileName = formattedDate.concat("/"+provider + ".json");


        try{

            for(Map<String, Object> data : information){

                System.out.println(data);
            }


            ObjectMapper mapper = new ObjectMapper();

            String updatedJson = mapper.writeValueAsString(information);

            try (FileOutputStream outputStream = new FileOutputStream(fileName)) {
                outputStream.write(updatedJson.getBytes());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }catch (JsonProcessingException e){

            System.out.println(e.getMessage());

        }


        getValues(fileName, provider);

    }

    private static void getValues(String path, String provider) throws IOException {

        String formattedDate = excelDirectory.concat(Events.FORMATTER.dateFormat());

        File theDir = new File(formattedDate);
        if (!theDir.exists()){
            theDir.mkdirs();
        }


        ObjectMapper mapper = new ObjectMapper();
        List<Map<String, Object>> information = mapper.readValue(new FileReader(path), List.class);

        Workbook workbook = new HSSFWorkbook();

        for(Map<String, Object> categoryData : information){


            String categoryName = (String) categoryData.get("category");
            Sheet sheet = workbook.createSheet(categoryName);


            Row headerRow = sheet.createRow(0);
            Cell fileListCell = headerRow.createCell(0);
            fileListCell.setCellValue("File List:");
            Cell lobbyListCell = headerRow.createCell(1);
            lobbyListCell.setCellValue("Lobby List:");

            // Data Rows
            int rowIndex = 1;

            // fileList (single cell with comma-separated values)
            List<String> fileList = (List<String>) categoryData.get("fileList");
            for (String item : fileList) {
                Row fileListRow = sheet.createRow(rowIndex++);
                Cell fileListValueCell = fileListRow.createCell(0);
                fileListValueCell.setCellValue(item);
            }

            // lobbyList (separate cells)
            List<String> lobbyList = (List<String>) categoryData.get("lobbyList");
            for (String item : lobbyList) {
                Row lobbyListRow = sheet.createRow(rowIndex++);
                Cell lobbyListValueCell = lobbyListRow.createCell(1);
                lobbyListValueCell.setCellValue(item);
            }

        }


        String file = formattedDate.concat("/"+provider.toLowerCase()+".xls");
        // Write to Excel file
        FileOutputStream outputStream = new FileOutputStream(file);
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();

        System.out.println("JSON data converted to Excel successfully!");

    }
}

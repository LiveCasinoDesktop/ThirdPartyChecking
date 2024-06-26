package Utilities.Helper;


import Utilities.Listeners.Events;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.List;
import java.util.Map;

public class JsonFormatter {

    static String jsonDirectory = "json/";
    static String excelDirectory = "excel/";
    public static void generate(List<Map<String, Object>> information, String provider) throws IOException {

        String formattedDate = "reports/"+Events.FORMATTER.dateFormat().concat("/"+jsonDirectory);

        File theDir = new File(formattedDate);
        if (!theDir.exists()){
            theDir.mkdirs();
        }

        String fileName = formattedDate.concat("/"+provider + ".json");

        try{

            for(Map<String, Object> data : information){System.out.println(data
            );}

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
        String formattedDate = "reports/"+Events.FORMATTER.dateFormat().concat("/"+excelDirectory);

        File theDir = new File(formattedDate);

        if (!theDir.exists()){theDir.mkdirs();}

        ObjectMapper mapper = new ObjectMapper();
        List<Map<String, Object>> information = mapper.readValue(new FileReader(path), List.class);

        Workbook workbook = new XSSFWorkbook();
        CellStyle headerStyle;

        headerStyle = workbook.createCellStyle();
        headerStyle.setAlignment(HorizontalAlignment.CENTER);

        XSSFFont headerFont = (XSSFFont) workbook.createFont();
        headerFont.setBold(true);
        headerFont.setFontHeightInPoints((short) 14);
        headerStyle.setFont(headerFont);

        for(Map<String, Object> categoryData : information){

            // fileList (single cell with comma-separated values)
            List<String> baseList = (List<String>) categoryData.get("baseList");
            // fileList (single cell with comma-separated values)
            List<String> addedList = (List<String>) categoryData.get("addedList");
            List<String> addedTimeStampList = (List<String>) categoryData.get("addedTimeStamp");
            // lobbyList (separate cells)
            List<String> removedList = (List<String>) categoryData.get("removedList");
            List<String> removedTimeStampList = (List<String>) categoryData.get("removedTimeStamp");

            String categoryName = (String) categoryData.get("category");
            Sheet sheet = workbook.createSheet(categoryName);
            Row headerRow = sheet.createRow(0);

            headersCells(headerRow, headerStyle);

            // Data Rows
            int rowIndex = 1;

            Row baseListRow, addedListRow, removedListRow;
            Cell baseListValueCell, addedListValueCell, removedListValueCell;

            // * INPUTTING ALL BASE TABLE THAT ARE ON THE FILE LIST
            for (String item : baseList) {
                System.out.println(item);
                baseListRow = sheet.createRow(rowIndex++);
                baseListValueCell = baseListRow.createCell(0);
                baseListValueCell.setCellValue(item);
            }
            // Data Rows
            rowIndex = 1;

            // * IF FILE LIST IS NOT NULL, PRINT ALL VALUES. ELSE, PRINT NO ISSUE
            if(!addedList.isEmpty()){

                for (String item : addedList) {
                    System.out.println(item);
                    addedListRow = sheet.getRow(rowIndex++);
                    addedListValueCell = addedListRow.createCell(2);
                    addedListValueCell.setCellValue(item);
                }
            }
            else{

                addedListRow = sheet.getRow(rowIndex);
                addedListValueCell = addedListRow.createCell(2);
                addedListValueCell.setCellValue("No Issue");
            }

            // Data Rows
            rowIndex = 1;
            // ? INPUT ALL TIMESTAMP
            if(!addedTimeStampList.isEmpty()){

                for (String item : addedTimeStampList) {
                    System.out.println(item);
                    addedListRow = sheet.getRow(rowIndex++);
                    addedListValueCell = addedListRow.createCell(3);
                    addedListValueCell.setCellValue(item);
                }
            }
            // Data Rows
            rowIndex = 1;

            // * IF LOBBY LIST IS NOT NULL, PRINT ALL VALUES. ELSE, PRINT NO ISSUE
            if(!removedList.isEmpty()){

                for (String item : removedList) {
                    System.out.println(item);
                    removedListRow = sheet.getRow(rowIndex++);
                    removedListValueCell = removedListRow.createCell(5);
                    removedListValueCell.setCellValue(item);
                }
            }
            else{

                removedListRow = sheet.getRow(rowIndex);
                removedListValueCell = removedListRow.createCell(5);
                removedListValueCell.setCellValue("No Issue");
            }

            // Data Rows
            rowIndex = 1;
            // ? INPUT ALL TIMESTAMP
            if(!removedTimeStampList.isEmpty()){

                for (String item : removedTimeStampList) {
                    System.out.println(item);
                    addedListRow = sheet.getRow(rowIndex++);
                    addedListValueCell = addedListRow.createCell(6);
                    addedListValueCell.setCellValue(item);
                }
            }

            sheet.autoSizeColumn(0);
            sheet.autoSizeColumn(2);
            sheet.autoSizeColumn(3);
            sheet.autoSizeColumn(5);
            sheet.autoSizeColumn(6);

        }


        String file = formattedDate.concat("/"+provider.toLowerCase()+".xlsx");

        // Write to Excel file
        FileOutputStream outputStream = new FileOutputStream(file);
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();

        System.out.println("JSON data converted to Excel successfully!");

    }


    // ? CREATE HEADERS CELLS
    private static void headersCells(Row headerRow, CellStyle headerStyle){

        Cell baseListCell = headerRow.createCell(0);
        baseListCell.setCellValue("Base List:");
        baseListCell.setCellStyle(headerStyle);

        Cell addedListCell = headerRow.createCell(2);
        addedListCell.setCellValue("Added List:");
        addedListCell.setCellStyle(headerStyle);

        Cell addedTimeStampCell = headerRow.createCell(3);
        addedTimeStampCell.setCellValue("Timestamp:");
        addedTimeStampCell.setCellStyle(headerStyle);

        Cell removedListCell = headerRow.createCell(5);
        removedListCell.setCellValue("Removed List:");
        removedListCell.setCellStyle(headerStyle);

        Cell removedTimeStampCell = headerRow.createCell(6);
        removedTimeStampCell.setCellValue("Timestamp:");
        removedTimeStampCell.setCellStyle(headerStyle);
    }
}

package Utilities.Listeners;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileAttachments {

    public static List<String> attachFiles(){

        List<String> textFileList = new ArrayList<>();

        String currDate;

        currDate = Events.FORMATTER.dateFormat();

        System.out.println("Current Date: " + currDate);
        String date = "reports/excel/" + currDate + "/";
        System.out.println("Path: " + date);

        List<String> textFiles = listFiles(date);

        for(String file : textFiles){

            String filePath = date + file;
            System.out.println("File Path: " + filePath);

            textFileList.add(filePath);

        }

        return textFileList;
    }

    private static List<String> listFiles(String directoryPath){

        List<String> textFiles = new ArrayList<>();

        File directory = new File(directoryPath);

        File[] files = directory.listFiles();

        if(files != null){

            for (File file : files) {
                if (isTextFile(file)) {
                    textFiles.add(file.getName());
                }
            }

        }

        return textFiles;
    }

    private static boolean isTextFile(File file) {
        // Define the allowed image file extensions
        String[] allowedExtensions = {".xls"};

        // Check if the file has one of the allowed extensions
        return Arrays.stream(allowedExtensions).anyMatch(ext -> file.getName().toLowerCase().endsWith(ext));
    }
}

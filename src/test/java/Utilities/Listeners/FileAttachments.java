package Utilities.Listeners;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileAttachments {

    private static String provider;
    public static List<String> attachFiles(){

        List<String> textFileList = new ArrayList<>();

        String currDate;

        currDate = Events.FORMATTER.dateFormat();

        System.out.println("Current Date: " + currDate);
        String date = "reports/excel/" + currDate + "/";
        System.out.println("Path: " + date);

        List<String> textFiles = listFiles(date, false);

        for(String file : textFiles){

            String filePath = date + file;
            System.out.println("File Path: " + filePath);

            textFileList.add(filePath);

        }

        return textFileList;
    }

    private static List<String> listFiles(String directoryPath, boolean isSpecific){

        List<String> textFiles = new ArrayList<>();

        File directory = new File(directoryPath);

        File[] files = directory.listFiles();

        if(files != null){

            for (File file : files) {

                if(isSpecific){

                    if(isSpecific(file)){
                        textFiles.add(file.getName());
                    }

                }

                else{

                    if (isTextFile(file)) {
                        textFiles.add(file.getName());
                    }
                }
            }

        }

        return textFiles;
    }

    private static boolean isTextFile(File file) {
        // Define the allowed image file extensions
        String[] allowedExtensions = {".xlsx"};

        // Check if the file has one of the allowed extensions
        return Arrays.stream(allowedExtensions).anyMatch(ext -> file.getName().toLowerCase().endsWith(ext));
    }


    // * SPECIFIC ATTACH FILE
    public static List<String> attachFiles(String provider){

        FileAttachments.provider = provider;

        List<String> textFileList = new ArrayList<>();

        String currDate;

        currDate = Events.FORMATTER.dateFormat();

        System.out.println("Current Date: " + currDate);
        String date = "reports/"+currDate+"/excel/";
        System.out.println("Path: " + date);

        List<String> textFiles = listFiles(date, true);

        for(String file : textFiles){

            String filePath = date + file;
            System.out.println("File Path: " + filePath);

            textFileList.add(filePath);

        }

        return textFileList;
    }

    private static boolean isSpecific(File file) {
        // Define the allowed image file extensions

        String fileName = provider.toLowerCase().concat(".xlsx");

        System.out.println(fileName);
        System.out.println(file.getName());

        // Check if the file has one of the allowed extensions
        return file.getName().equals(fileName);
    }

}

package Utilities.Listeners;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

public class JsonGenerator {

    public static void providerFile(String provider, String category, List<String> fileList, List<String> lobbyList) throws IOException {

        String formattedDate = Events.FORMATTER.dateFormat();
        String fileName = provider + ".json";
        //String filePath = formattedDate + "/" + fileName;
        String filePath = fileName;

        List<Map<String, Object>> information = new ArrayList<>();
        Map<String, Object> data = new LinkedHashMap<>();
        List<Map<String, Object>> existing;


        File file = new File(filePath);

        if (file.exists()) {

            // Read existing data
            ObjectMapper mapper = new ObjectMapper();
            data = mapper.readValue(file, Map.class);
            System.out.println("Data read from existing file.");

        } else {

            // Create a new file (empty initially)
            file.createNewFile();
            System.out.println("File created (or already exists).");

        }

        data.put("category", category);
        data.put("fileList", fileList);
        data.put("lobbyList", lobbyList);


        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> existingData;

        if(file.length() > 0){

            existingData = mapper.readValue(file, Map.class);

            information.add(existingData);

        }
        information.add(data);

        String updatedJson = mapper.writeValueAsString(information);

        try (FileOutputStream outputStream = new FileOutputStream(filePath)) {
            outputStream.write(updatedJson.getBytes());
        }
    }
}

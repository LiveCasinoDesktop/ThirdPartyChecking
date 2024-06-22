package engine;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.stream.Stream;


public class GoogleChromeDriver extends ChromeDriver {

    GoogleChromeDriver(){super(getCaps());}

    private static ChromeOptions getCaps() {

        ChromeOptions chromeOptions = new ChromeOptions();

//        chromeOptions.addArguments("--headless");
        chromeOptions.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
        System.setProperty(ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY, getExecutable());


        return chromeOptions;

    }
    private static String getExecutable() {
        InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("chromedriver.exe");
        File exe = null;
        try {
            exe = File.createTempFile("chromedriver", ".exe");
            FileUtils.copyInputStreamToFile(is, exe);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return Objects.requireNonNull(exe).getAbsolutePath();
    }

//    private static String getExecutable(){
//        // Define the root directory to start the search
//        String rootDirectory = "C:\\chromedriver\\";
//        String fileName = "chromedriver.exe";
//
//        try (Stream<Path> paths = Files.walk(Paths.get(rootDirectory))) {
//            return paths
//                    .filter(Files::isRegularFile)
//                    .filter(path -> path.getFileName().toString().equals(fileName))
//                    .map(Path::toAbsolutePath)
//                    .map(Path::toString)
//                    .findFirst()
//                    .orElse(null);
//        } catch (IOException e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
}



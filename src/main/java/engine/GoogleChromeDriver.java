package engine;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;

import java.util.function.Predicate;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;


public class GoogleChromeDriver extends ChromeDriver {

    GoogleChromeDriver(){super(getCaps());}

    private static ChromeOptions getCaps() {
        Map<String, Object> deviceMetrics = new HashMap<>();

//        deviceMetrics.put("deviceName", "Nexus 5");
//        deviceMetrics.put("width", 460);
//        deviceMetrics.put("height", 840);
//        deviceMetrics.put("pixelRatio", 3.0);

        Map<String, Object> mobileEmulation = new HashMap<>();
        mobileEmulation.put("deviceMetrics", deviceMetrics);
        mobileEmulation.put("userAgent", "Mozilla/5.0 (Linux; Android 4.2.1; en-us; Nexus 5 Build/JOP40D) AppleWebKit/535.19 (KHTML, like Gecko) Chrome/18.0.1025.166 Mobile Safari/535.19");

        Map<String, Object> clientHints = new HashMap<>();
        clientHints.put("platform", "Android");
        clientHints.put("mobile", true);
        mobileEmulation.put("clientHints", clientHints);

        ChromeOptions chromeOptions = new ChromeOptions();

        //chromeOptions.addArguments("--headless");
        //chromeOptions.addArguments("--auto-open-devtools-for-tabs");
        chromeOptions.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
//        chromeOptions.setCapability("ignoreZoomSetting", true);
//        chromeOptions.setCapability("requireWindowFocus", false);
//        chromeOptions.setCapability("enablePersistentHover", false);
        //chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);
        //System.setProperty(ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY, getExecutable());


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
}



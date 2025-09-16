package drivers;

import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

import io.appium.java_client.android.AndroidDriver;

public class GmailDriver {
    public static AndroidDriver driver;

    private GmailDriver() {
        // Constructor privado para evitar instancias de la clase
        // Puedes dejarlo vacío o lanzar una excepción si deseas
    }
    public static GmailDriver ApertureDeGmail() {
        try {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("deviceName", "TC20");
            capabilities.setCapability("platformName", "Android");
            capabilities.setCapability("platformVersion", "7.1.2");
            capabilities.setCapability("automationName", "UiAutomator2");
            capabilities.setCapability("appPackage", "com.google.android.gm");
            capabilities.setCapability("appActivity", ".ConversationListActivityGmail");
            capabilities.setCapability("noReset", true);
            capabilities.setCapability("nativeWebTap", true);
            capabilities.setCapability("appium:eventTimings", true);
            capabilities.setCapability("newCommandTimeout", 45000);
            capabilities.setCapability("udid", "19045521401000");
            driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return new GmailDriver();
    }

    public static io.appium.java_client.AppiumDriver on() {
        return driver;
    }


//appium server -pa /wd/hub
}
